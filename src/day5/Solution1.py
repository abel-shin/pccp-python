# https://school.programmers.co.kr/learn/courses/30/lessons/49189

# 그래프에서 BFS를 이용하면 각 노드까지의 최단거리를 알 수 있다. (단, 모든 에지의 가중치가 동일한 경우)
# visited 배열 대신 distance 배열을 이용하면 방문 여부 대신 시작 노드로부터 거리를 알 수 있다.


def solution(n, edge):
    adj_list = [[] for _ in range(n+1)]
    
    for e in edge: # 인접 리스트로 변환
        adj_list[e[0]].append(e[1])
        adj_list[e[1]].append(e[0])
    
    distance = [-1] * (n+1) # 거리는 -1로 초기화 (-1는 방문하지 않았음을 의미)
    
    queue = []
    distance[1] = 0
    queue.append(1)
    
    while queue: # 큐를 이용한 BFS
        node = queue.pop(0)
        for adj_node in adj_list[node]:
            if distance[adj_node] == -1: # 방문하지 않은 인접 노드일 경우
                distance[adj_node] = distance[node] + 1 # 현재 노드까지의 거리 +1이 인접 노드까지의 거리가 된다.
                queue.append(adj_node)
    
    max_dist = max(distance)
    return len(list(filter(lambda x: x == max_dist, distance)))
