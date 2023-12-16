package day5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 그래프의 DFS와 BFS를 구현하세요.
 * 그래프의 edges는 양방향으로 연결되어 있습니다.
 * 중간 동작 과정을 알 수 있게, node에 접근할 때 마다 해당 노드의 번호를 콘솔에 출력하세요.
 */

class Practice2 {
    boolean found = false;
    List<Integer>[] adjList;
    boolean[] visited;

    boolean dfs(int node, int target, int n, int[][] edges) {
        adjList = new List[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] e: edges) {
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }

        solve(node, target);

        return found;
    }

    void solve(int node, int target) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;


        if (node == target) {
            System.out.println(node);
            found = true;
            return;
        }

        if (found) {
            return;
        }

        System.out.printf("%d ", node);

        for (int adjNode: adjList[node]) {
            solve(adjNode, target);
        }
    }


    boolean bfs(int node, int target, int n, int[][] edges) {
        List<Integer>[] adjList = new List[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] e: edges) {
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        boolean found = false;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;

            if (currNode == target) {
                System.out.println(currNode);
                found = true;
                break;
            } else {
                System.out.printf("%d ", currNode);
            }

            for (int adjNode: adjList[currNode]) {
                queue.offer(adjNode);
            }
        }

        return found;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{1, 4}, {2, 3}, {5, 2}, {3, 6}, {4, 3}, {7, 6}, {6, 2}};
        System.out.println(new Practice2().dfs(1, 6, n, edges));
        System.out.println(new Practice2().bfs(1, 6, n, edges));
    }
}