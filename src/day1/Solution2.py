# https://school.programmers.co.kr/learn/courses/30/lessons/140108


# 조건에 따라 문자열을 분리하는 문제입니다.
# 동일 동작을 분리된 문자열에 반복하여 적용하므로, 재귀 호출로 구현하면 쉽습니다.

def solution(s):
    count = 0 # 문자열 분리 횟수를 저장하는 변수
    def splitString(st):
        nonlocal count
        
        if len(st) == 0: # 빈 문자열이면 더 이상 분리할 수 없다.
            return
        
        x = st[0]  
        num_x = 1     # 첫 문자의 등장 횟수
        num_non_x = 0 # 첫 문자와 다른 문자 수
        split_i = -1  # 문자열을 분리할 인덱스
        for i in range(1, len(st)):
            if x == st[i]:
                num_x += 1
            else:
                num_non_x += 1
            
            if num_x == num_non_x: # 첫 문자와 다른 문자의 개수가 같으면 분리
                split_i = i
                break
        
        count += 1 # 분리가 발생할 때 count 증가
        if split_i != -1: # 더 분리할 문자열이 남아있으면 재귀 호출
            splitString(st[split_i+1:])
    
    splitString(s)
    
    return count
