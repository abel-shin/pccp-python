# https://school.programmers.co.kr/learn/courses/30/lessons/132265

# 해싱을 이용해 각 경우에 대해 토핑의 수를 빠르게 구하는 문제입니다.
# 해싱을 사용하지 않으면 매번 토핑을 세 주어야 하므로 O(N^2)이 됩니다.
# 해싱을 사용하면 토핑을 매번 1개씩 업데이트만 해주면 되므로 O(N)이 됩니다.
 

def solution(topping):
    map1 = dict()  # 왼쪽 롤케이크의 토핑별 개수
    map2 = dict()  # 오른쪽 롤케이크의 토핑별 개수
    
    for t in topping:  # 오른쪽 롤케이크에 모든 토핑 추가
        if t not in map2:
            map2[t] = 0
        map2[t] += 1
    
    answer = 0
    
    for t in topping: # 하나씩 왼쪽 롤케이크로 토핑을 옮긴다.
        if t not in map1: # 왼쪽 롤케이크에 i번째 토핑 하나 추가
            map1[t] = 0
        map1[t] += 1
        
        if map2[t] == 1: # 오른쪽 롤케이크에서 i번째 토핑 하나 제거
            del map2[t]
        else:
            map2[t] -= 1
        
        if len(map1) == len(map2): # 토핑의 종류의 수가 같으면 정답으로 카운트
            answer += 1
    
    return answer
