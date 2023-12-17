# 그래프의 DFS와 BFS를 구현하세요.
# 그래프는 무향그래프로, edges에 있는 간선들은 양방향으로 연결되어 있습니다.
# 중간 동작 과정을 알 수 있게, node에 접근할 때 마다 해당 노드의 번호를 콘솔에 출력하세요.


def dfs(node, target, n, edges):
    found = False
    visited = [False] * (n+1)
    adj_list = [[] for _ in range(n+1)]

    for e in edges:
        adj_list[e[0]].append(e[1])
        adj_list[e[1]].append(e[0])

    def solve(node, target):
        nonlocal found

        if visited[node]:
            return
        visited[node] = True

        if node == target:
            print(node)
            found = True
        
        if found:
            return
        
        print(node, end=' ')

        for adj_node in adj_list[node]:
            solve(adj_node, target)

    solve(node, target)
    return found


def bfs(node, target, n, edges):
    visited = [False] * (n+1)
    adj_list = [[] for _ in range(n+1)]
    for e in edges:
        adj_list[e[0]].append(e[1])
        adj_list[e[1]].append(e[0])
    
    queue = []
    queue.append(node)
    found = False

    while queue:
        curr_node = queue.pop(0)

        if visited[curr_node]:
            continue
        visited[curr_node] = True

        if curr_node == target:
            print(curr_node)
            found = True
            break
        else:
            print(curr_node, end=' ')
        
        for adj_node in adj_list[curr_node]:
            queue.append(adj_node)

    return found


if __name__ == '__main__':
    n = 7
    edges = [[1, 4], [2, 3], [5, 2], [3, 6], [4, 3], [7, 6], [6, 2]]
    print(dfs(1, 6, n, edges))
    print(bfs(1, 6, n, edges))
