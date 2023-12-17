# https://school.programmers.co.kr/learn/courses/30/lessons/70129

# 조건을 적절히 변경하여 구현하면 되는 문제입니다.
# 0을 실제로 제거하는 대신, 1의 개수만 세면 되는 점에 유의합시다.


def solution(s):
    trans_count = 0 # 변환 횟수
    zero_count = 0 # 제거한 0의 개수
    
    while s != '1': # 1이 되기 전까지 반복
        one_count = len(list(filter(lambda x: x == '1', s))) # 1의 개수를 새면 모든 0을 제거한 것과 같다.
        zero_count += len(s) - one_count
        s = format(one_count, 'b') # 1의 개수 = 0을 제거한 후의 자릿수
        trans_count += 1
    
    return [trans_count, zero_count]
