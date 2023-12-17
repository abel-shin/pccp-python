# https://school.programmers.co.kr/learn/courses/30/lessons/12915

# 문자열 정렬 조건을 바꾸어 보는 문제입니다.
# key와 익명함수를 이용하면 손쉽게 구현할 수 있습니다.

def solution(strings, n):
    strings.sort(key=lambda x: (x[n], x)) # n번째 문자열 우선 기준, 문자열 내용이 다음 기준
    return strings
