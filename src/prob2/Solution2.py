# https://school.programmers.co.kr/learn/courses/15009/lessons/121688

# 그리디 문제입니다.
# 매 회차마다 가장 능력이 작은 두 사원을 뽑으면 됩니다.
# 이를 가장 쉽게 구현하기 위해서는 Heap을 이용해 주면 됩니다.


import heapq

def solution(ability, number):
    heapq.heapify(ability)
    
    for i in range(number):
        a = heapq.heappop(ability)
        b = heapq.heappop(ability)
        heapq.heappush(ability, a + b)
        heapq.heappush(ability, a + b)
    
    return sum(ability)
