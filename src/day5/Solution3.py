# https://school.programmers.co.kr/learn/courses/30/lessons/1844

# BFS를 이용하는 대표적인 2차원 지도 문제입니다.
# BFS를 수행하면서 distance map을 계산해 나가는 방식으로 진행합니다.
# 원하는 위치에 도달하면 곧바로 BFS를 종료합니다.


def solution(maps):
    n = len(maps)
    m = len(maps[0])
    distance = [[-1] * m for _ in range(n)] # 방문하지 않았다는 의미로 -1로 초기화
    
    queue = []
    queue.append((0, 0))
    distance[0][0] = 1
    
    while queue:
        i, j = queue.pop(0)
        
        if i == n-1 and j == m-1: # 타겟 위치에 도달했으면 종료
            return distance[i][j] # 타겟 위치까지의 거리 반환
        
        curr_distance = distance[i][j] # 현재 노드까지의 거리
        
        # 이동 가능하면 현재 노드까지의 거리 +1로 거리 저장 & 큐에 추가
        if i > 0 and maps[i-1][j] == 1 and distance[i-1][j] == -1:
            distance[i-1][j] = curr_distance + 1
            queue.append((i-1, j))
        if j > 0 and maps[i][j-1] == 1 and distance[i][j-1] == -1:
            distance[i][j-1] = curr_distance + 1
            queue.append((i, j-1))
        if i < n-1 and maps[i+1][j] == 1 and distance[i+1][j] == -1:
            distance[i+1][j] = curr_distance + 1
            queue.append((i+1, j))
        if j < m-1 and maps[i][j+1] == 1 and distance[i][j+1] == -1:
            distance[i][j+1] = curr_distance + 1
            queue.append((i, j+1))
        
    return -1 # 큐가 비어도 도달하지 못했으면 -1 반환
