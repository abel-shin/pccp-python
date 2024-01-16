# https://school.programmers.co.kr/learn/courses/30/lessons/42626

# 가장 맵지 않은 음식과 두 번째로 맵지 않은 음식을 빠르게 찾는 문제
# heap을 사용하여 자료의 삽입/삭제를 빠르게 수행해야 합니다.
# 스코빌 지수가 K에 도달하지 못하는 경우 예외처리를 적절히 해 주어야 합니다.


from heapq import heapify, heappop, heappush

def solution(scoville, K):
    heapify(scoville)
    
    answer = 0
    while scoville[0] < K:
        s1 = heappop(scoville) # 가장 맵지 않은 음식 삭제
        s2 = heappop(scoville) # 두 번째로 맵지 않은 음식 삭제
        s = s1 + s2 * 2
        heappush(scoville, s) # 섞은 음식 삽입
        answer += 1
        
        if len(scoville) == 1 and scoville[0] < K: # K에 도달하지 못하는 경우
            return -1
    
    return answer
