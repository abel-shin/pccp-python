# https://school.programmers.co.kr/learn/courses/30/lessons/42587

# 큐를 이용한 프로세스 처리를 충실하게 시뮬레이션하는 문제입니다.
# 문제에서 제시된 대로 시뮬레이션하면서, 답안이 발생하면 곧바로 시뮬레이션을 종료합니다.


from collections import deque

def solution(priorities, location):
    answer = 0
    queue = deque()
    
    for p in priorities:
        queue.append(p) # 큐에 모든 작업 삽입
    
    while queue:
        max_p = max(queue) # 큐에 있는 최대 priority
        
        if queue[0] >= max_p: # 현재 작업의 우선순위가 가장 높으면 처리
            answer += 1
            
            if location == 0: # 원하는 location의 작업이 처리됐으면 시뮬레이션 종료
                break
            else: # 원하는 location이 아니면 계속해서 진행
                queue.popleft()
                location -= 1
        else: # 우선순위가 낮으면 큐에 다시 추가
            queue.append(queue[0])
            queue.popleft()
            
            if location == 0: # 원하는 작업이지만 처리되지 않았을 경우, location 초기화
                location = len(queue) - 1
            else: # 원하는 작업이 아닐 경우 location 조정
                location -= 1
    
    return answer
