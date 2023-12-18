# https://school.programmers.co.kr/learn/courses/30/lessons/159993

# 시작 위치에서 레버까지, 레버 위치에서 출구까지를 별도로 계산하면 되는 BFS문제입니다.
# 이미 지났던 길을 다시 가도 된다고 하지만, 최단거리를 가려면 그럴 이유가 없습니다.
# 단, 레버까지 가면서 지났던 길은 출구로 가면서 다시 갈 수도 있으므로 두 BFS는 독립적입니다.


def solution(maps):
    def bfs(start_pos, target_pos):
        d_i = [-1, 1, 0, 0]
        d_j = [0, 0, -1, 1]
        
        queue = []
        distance = [[-1] * len(maps[0]) for _ in range(len(maps))] # 거리를 -1로 초기화 (방문하지 않았다는 의미)
        
        queue.append(start_pos)
        distance[start_pos[0]][start_pos[1]] = 0
        
        while queue: # BFS
            i, j = queue.pop(0)
            
            if (i, j) == target_pos: # 타겟에 도착하면 종료
                return distance[i][j] # 타겟까지의 거리를 반환
            
            for di, dj in zip(d_i, d_j):
                new_i, new_j = i + di, j + dj
                
                if (0 <= new_i < len(maps) and
                   0 <= new_j < len(maps[0]) and
                   maps[new_i][new_j] != 'X' and
                   distance[new_i][new_j] == -1):
                    distance[new_i][new_j] = distance[i][j] + 1
                    queue.append((new_i, new_j))
            
        return -1
    
    for i in range(len(maps)): # 시작점, 끝점, 레버위치 기록
        for j in range(len(maps[0])):
            if maps[i][j] == 'S':
                start_pos = (i, j)
            elif maps[i][j] == 'E':
                end_pos = (i, j)
            elif maps[i][j] == 'L':
                lever_pos = (i, j)
    
    lever_dist = bfs(start_pos, lever_pos) # 레버까지 거리 BFS로 구하기
    
    if lever_dist == -1: # 도달할 수 없으면 -1 반환
        return -1
    
    end_dist = bfs(lever_pos, end_pos) # 레버에서 끝까지 거리 BFS로 구하기
    
    if end_dist == -1: # 도달할 수 없으면 -1 반환
        return -1
    
    return lever_dist + end_dist # 두 거리의 합 반환
