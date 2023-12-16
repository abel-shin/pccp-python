package day5;

// https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/*
 * 그래프에서 BFS를 이용하면 각 노드까지의 최단거리를 알 수 있다. (단, 모든 에지의 가중치가 동일한 경우)
 * visited 배열 대신 distance 배열을 이용하면 방문 여부 대신 시작 노드로부터 거리를 알 수 있다.
 */

class Solution1 {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n+1; i++) { // 인접 리스트로 변환
            adj.add(new ArrayList<>());
        }
        
        for (int[] e: edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int[] distance = new int[n+1]; // 거리는 -1로 초기화 (-1는 방문하지 않았음을 의미)
        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        distance[1] = 0;
        queue.offer(1);
        
        while (!queue.isEmpty()) { // 큐를 이용한 BFS
            int node = queue.poll();
            for (int adjNode: adj.get(node)) {
                if (distance[adjNode] == -1) { // 방문하지 않은 인접 노드일 경우
                    distance[adjNode] = distance[node] + 1; // 현재 노드까지의 거리 +1이 인접 노드까지의 거리가 된다.
                    queue.offer(adjNode);
                }
            }
        }

        int maxVal = Arrays.stream(distance).max().getAsInt(); // one-line 최대값 계산
        return (int)Arrays.stream(distance).filter(x -> x == maxVal).count(); // one-line 최대값 개수 세기
    }
}