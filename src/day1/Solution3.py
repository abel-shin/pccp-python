# https://school.programmers.co.kr/learn/courses/30/lessons/42576

# 해싱을 이용하여 두 배열을 효율적으로 비교하는 문제입니다.
# 해싱하지 않고 비교할 경우 시간복잡도는 O(N^2)입니다.
# 해싱을 하고 비교할 경우 시간 복잡도는 O(N)입니다.
# 동명이인이 없다면 Set을 이용하여 비교할 수 있겠지만, 동명이인을 고려하여 딕셔너리를 이용해서 비교해야 합니다.


def solution(participant, completion):
    part_map = dict()  # 참가자의 이름-인원 수 딕셔너리
    comp_map = dict()  # 완주자의 이름-인원 수 딕셔너리

    for s in participant: # 참가자 이름별 인원 수 계산
        if s not in part_map:
            part_map[s] = 0
        part_map[s] += 1
    
    for s in completion: # 참가자 이름별 인원 수 계산
        if s not in comp_map:
            comp_map[s] = 0
        comp_map[s] += 1
    
    for s in part_map:
        if (s not in comp_map or  # 참가자 중에 완주자 명단에 없는 경우
             part_map[s] != comp_map[s]): # 참가자 수와 완주자 수가 다른 경우
            return s
    
    return ''
