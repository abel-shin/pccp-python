# https://school.programmers.co.kr/learn/courses/30/lessons/12946

# 재귀 구현의 기본이자 넘어야 할 벽, 하노이의 탑입니다.
# 점화식과 종료조건을 정확하게 이해하고 구현해 봅시다.


def solution(n):
    def hanoi(start, end, support, n):
        if n == 1:
            return [[start, end]]
        return hanoi(start, support, end, n-1) + [[start, end]] + hanoi(support, end, start, n-1)
    
    return hanoi(1, 3, 2, n)
