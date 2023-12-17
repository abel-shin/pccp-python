# https://school.programmers.co.kr/learn/courses/30/lessons/42586

# 큐를 사용하는 대표적인 예제입니다.
# 입선출의 특징을 이용해 순서대로 일이 처리될 수 있게 합니다.
# 한번에 배포되는 단위를 끊기 위해, 큐에는 일처리에 걸리는 일 수를 입력합니다.


from math import ceil

def solution(progresses, speeds):
    queue = []
    answer = []
    
    for i in range(len(speeds)):
        remain = (100 - progresses[i]) / speeds[i]
        date = ceil(remain) # i번째 작업의 처리에 걸리는 일 수
        
        if queue and queue[0] < date: #  i번째 작업보다 일찍 배포가 가능해졌을 때, 큐에 쌓인 모든 작업 배포
            answer.append(len(queue))
            queue.clear()
        
        queue.append(date) # i번째 작업을 큐에 추가
    
    answer.append(len(queue)) # 마지막에 큐에 쌓여있는 모든 작업 배포
    return answer
