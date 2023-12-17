# 트리의 DFS와 BFS를 구현하세요.
# 중간 동작 과정을 알 수 있게, node에 접근할 때 마다 해당 노드의 번호를 콘솔에 출력하세요.


def dfs(node, target, n, edges):
    found = False
    
    adj_list = [[] for _ in range(n+1)]
    for e in edges:
        adj_list[e[0]].append(e[1])

    def solve(node, target):
        nonlocal found

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
    adj_list = [[] for _ in range(n+1)]
    for e in edges:
        adj_list[e[0]].append(e[1])
    
    queue = []
    queue.append(node)
    found = False

    while queue:
        curr_node = queue.pop(0)

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
    n = 9
    edges = [[1, 2], [1, 3], [2, 4], [3, 5], [3, 6], [5, 7], [7, 8], [6, 9]]
    print(dfs(1, 6, n, edges))
    print(bfs(1, 9, n, edges))
