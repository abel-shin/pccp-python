package day5;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.Queue;
import java.util.LinkedList;

/*
 * BFS를 이용하는 대표적인 2차원 지도 문제입니다.
 * BFS를 수행하면서 distance map을 계산해 나가는 방식으로 진행합니다.
 * 원하는 위치에 도달하면 곧바로 BFS를 종료합니다.
 */

class Solution3 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] distance = new int[n][m];
        
        for (int i = 0; i < n; i++) { // 방문하지 않았다는 의미로 -1로 초기화
            for (int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        distance[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];
            
            if (i == n-1 && j == m-1) { // 타겟 위치에 도달했으면 종료
                return distance[i][j]; // 타겟 위치까지의 거리 반환
            }
            
            
            int currDistance = distance[i][j]; // 현재 노드까지의 거리
            
            if (i > 0 && maps[i-1][j] == 1 && distance[i-1][j] == -1) { // 이동 가능하면 현재 노드까지의 거리 +1로 거리 저장 & 큐에 추가
                distance[i-1][j] = currDistance + 1;
                queue.offer(new int[]{i-1, j});
            }
            if (j > 0 && maps[i][j-1] == 1 && distance[i][j-1] == -1) {
                distance[i][j-1] = currDistance + 1;
                queue.offer(new int[]{i, j-1});
            }
            if (i < n-1 && maps[i+1][j] == 1 && distance[i+1][j] == -1) {
                distance[i+1][j] = currDistance + 1;
                queue.offer(new int[]{i+1, j});
            }
            if (j < m-1 && maps[i][j+1] == 1 && distance[i][j+1] == -1) {
                distance[i][j+1] = currDistance + 1;
                queue.offer(new int[]{i, j+1});
            }            
        }

        return -1; // 큐가 비어도 도달하지 못했으면 -1 반환
    }
}