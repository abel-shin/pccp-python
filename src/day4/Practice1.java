package day4;

/*
 * 트리의 DFS와 BFS를 구현하세요.
 * 중간 동작 과정을 알 수 있게, node에 접근할 때 마다 해당 노드의 번호를 콘솔에 출력하세요.
 */

class Practice1 {
    boolean dfs(int node, int target, int n, int[][] edges) {
        // node를 시작점으로 하여, target 노드를 탐색하세요.
        // 탐색 결과를 true/false로 반환하세요.
        // 동작 과정을 확인하기 위해 node에 접근할 때 마다 해당 노드의 번호를 콘솔에 출력하세요.
        return true;
    }

    boolean bfs(int node, int target, int n, int[][] edges) {
        // node를 시작점으로 하여, target 노드를 탐색하세요.
        // 탐색 결과를 true/false로 반환하세요.
        // 동작 과정을 확인하기 위해 node에 접근할 때 마다 해당 노드의 번호를 콘솔에 출력하세요.
        return true;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {5, 7}, {7, 8}, {6, 9}};
        System.out.println(new Practice1().dfs(1, 6, n, edges));
        System.out.println(new Practice1().bfs(1, 9, n, edges));
    }
}