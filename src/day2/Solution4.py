# https://school.programmers.co.kr/learn/courses/30/lessons/42885

# 구명 보트에 2명밖에 탑승이 불가하므로, 
# 가장 무거운 사람과 가장 가벼운 사람을 탐욕법으로 선택하면 되는 문제입니다.
# 탐욕법이 항상 그렇듯, 정렬이 필요한지 여부를 고려해야 합니다.


def solution(people, limit):
    answer = 0
    people.sort() # 정렬을 해 주어야 무거운 사람과 가벼운 사람을 하나씩 접근 가능
    
    i_small = 0
    i_big = len(people) - 1
    while i_big >= i_small: 
        if people[i_big] + people[i_small] <= limit: # 가장 무거운 사람과 가장 가벼운 사람이 되는지 확인
            i_small += 1 # 가벼운 사람이 보트를 탔으면, 다음 가벼운 사람으로 인덱스 증가
            answer += 1
        else: # 함께 탈 수 없으면 가장 무거운 사람만 혼자 이동
            answer += 1
        i_big -= 1
            
    return answer