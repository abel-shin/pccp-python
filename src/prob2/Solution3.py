# https://school.programmers.co.kr/learn/courses/15009/lessons/121689

# 큐를 이용하는 시뮬레이션 문제입니다.
# 손님이 오는 이벤트와 다음 주문이 시작되는 이벤트를 함께 처리해야 합니다.


def solution(menu, order, k):
    answer = 0
    n = len(order)
    queue = []
    i = 0
    time = 0
    
    while queue or i < n: # 주문이 다 떨어지면 종료
        if not queue: # 기다리고 있는 손님이 없으면 다음 손님이 오는 시간으로 이동
            time = (i * k) + menu[order[i]]
            i += 1
        else:
            time += menu[queue.pop(0)] # 기다리는 손님이 있으면 해당 손님 주문 받기
        
        while i < n and i <= (time - 1) // k: # 시간이 지난 동안 온 손님 추가
            queue.append(order[i])
            i += 1
        
        answer = max(answer, len(queue))
    
    return answer + 1 # 주문한 손님까지 포함
