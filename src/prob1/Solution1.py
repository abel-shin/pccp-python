# https://school.programmers.co.kr/learn/courses/15008/lessons/121683

# 주어진 조건에 맞는 출력을 계산하는 구현문제입니다.
# 다양한 방법으로 구현할 수 있습니다. 각자 편한 방법으로 빠르고 정확하게 구현해 봅시다.


from collections import Counter

def solution(input_string):
    counter = Counter(list(input_string)) # 알파벳 별로 개수를 카운트합니다.
    answers = [] # 정답에 해당하는 알파벳을 모을 리스트
    for c in counter:
        if input_string.find(c * counter[c]) < 0: # 개수만큼 이어붙인 문자열이 없으면 외톨이 알파벳
            answers.append(c)
    
    answers.sort()
    answer = ''.join(answers)
    return answer if answer else 'N'
