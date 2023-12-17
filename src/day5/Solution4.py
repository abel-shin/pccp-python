# https://school.programmers.co.kr/learn/courses/30/lessons/12935

# 가볍게 풀 수 있는 구현 문제입니다.
# 이런 문제는 생산성 있게 빠르고 정확하게 해결하도록 연습합시다!


def solution(arr):
    min_val = min(arr)
    answer = list(filter(lambda x: x != min_val, arr))
    return answer if answer else [-1]
