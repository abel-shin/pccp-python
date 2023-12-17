# https://school.programmers.co.kr/learn/courses/30/lessons/42746

# 우선, 정렬 문제인지 알아채는 것이 중요한 문제입니다.
# 문자열을 이어붙이는 순서에 따라 어떤 방법이 더 큰 수를 만드는지 비교하여 정렬합니다.
# key 대신 compare 함수를 입력받을 수 있는 cmp_to_key를 이용하면 됩니다.
# compare 함수: a, b 중 a가 더 크면 양수, 더 작으면 음수를 반환하는 함수

from functools import cmp_to_key

def solution(numbers):
    def comp(a, b): # 숫자를 문자열로 바꾼 뒤, 이어붙이는 순서에 따라 대소 비교
        x = int(str(a) + str(b))
        y = int(str(b) + str(a))
        return y - x  # 값이 더 커지는 순서로 정렬
    
    numbers.sort(key=cmp_to_key(comp)) # cmp_to_key로 compare 함수 사용
    answer = str(int(''.join(map(str, numbers)))) # 숫자 이어붙이기. int변환은 00, 000같은 경우를 고려
    return answer
