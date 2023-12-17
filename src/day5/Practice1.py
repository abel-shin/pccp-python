# 그래프의 DFS와 BFS를 구현하세요.
# 그래프는 무향그래프로, edges에 있는 간선들은 양방향으로 연결되어 있습니다.
# 중간 동작 과정을 알 수 있게, node에 접근할 때 마다 해당 노드의 번호를 콘솔에 출력하세요.


def dfs(node, target, n, edges):
    # node를 시작점으로 하여, target 노드를 탐색하세요.
    # 탐색 결과를 true/false로 반환하세요.
    # 동작 과정을 확인하기 위해 node에 접근할 때 마다 해당 노드의 번호를 콘솔에 출력하세요.
    return True


def bfs(node, target, n, edges):
    # node를 시작점으로 하여, target 노드를 탐색하세요.
    # 탐색 결과를 true/false로 반환하세요.
    # 동작 과정을 확인하기 위해 node에 접근할 때 마다 해당 노드의 번호를 콘솔에 출력하세요.
    return True


if __name__ == '__main__':
    n = 7
    edges = [[1, 4], [2, 3], [5, 2], [3, 6], [4, 3], [7, 6], [6, 2]]
    print(dfs(1, 6, n, edges))
    print(bfs(1, 6, n, edges))
