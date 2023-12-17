# https://school.programmers.co.kr/learn/courses/30/lessons/12910

# 주어진 조건대로 충실하게 구현하는 문제입니다.
# 나누어 떨어지는 수를 모으고, 정렬하는 단순한 과정을 최대한 생산성 있게 구현해봅시다.
# 최종 배열의 크기가 0인 경우 [-1]을 반환하는 것도 잊지 않고 구현합니다.


def solution(arr, divisor):
    answer = [x for x in arr if x % divisor == 0]
    answer.sort()
    return answer if answer else [-1]
