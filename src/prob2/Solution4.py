# https://school.programmers.co.kr/learn/courses/15009/lessons/121690

# BFS를 이용한 최단 거리 문제입니다.
# 신비로운 신발을 사용한 경우와 사용하지 않은 경우를 나누어 visited를 생성하는 것이 핵심입니다.


def solution(n, m, hole):
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    
    board = [[0] * m for _ in range(n)]
    for i, j in hole: # 구멍이 있으면 1, 없으면 0
        board[i-1][j-1] = 1
    
    queue = []
    visited = [[[False] * 2 for _ in range(m)] for _ in range(n)] # 위치별, 신발 사용 여부별 노드 방문 여부
    visited[0][0][0] = True
    queue.append((0, 0, 0))
    answer = 0
    
    while queue:
        N = len(queue)
        for i in range(N): # 한 번 이동하는 모든 방법 확인
            x, y, used = queue.pop(0)
            
            for dx_, dy_ in zip(dx, dy):
                new_x = x + dx_
                new_y = y + dy_
                
                if (0 <= new_x < n and # 새 위치가 보드를 벗어나는지 여부
                    0 <= new_y < m and
                   not visited[new_x][new_y][used] and # 새 위치의 방문 여부
                   board[new_x][new_y] == 0): # 새 위치에 구멍이 있는지 여부
                    if (new_x, new_y) == (n-1, m-1): # 보물에 도착시 종료
                        return answer + 1
                    visited[new_x][new_y][used] = True
                    queue.append((new_x, new_y, used))
                
                if used == 0: # 신발을 사용하지 않았을 경우 사용하는 경우도 탐색
                    new_x += dx_ # 같은 방향으로 한칸 더 움직임
                    new_y += dy_
                    if (0 <= new_x < n and
                        0 <= new_y < m and
                       not visited[new_x][new_y][1] and
                       board[new_x][new_y] == 0):
                        if (new_x, new_y) == (n-1, m-1):
                            return answer + 1
                        visited[new_x][new_y][1] = True
                        queue.append((new_x, new_y, 1))
                    
        answer += 1
    
    return -1
