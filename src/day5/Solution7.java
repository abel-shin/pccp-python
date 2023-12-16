package day5;

// https://school.programmers.co.kr/learn/courses/30/lessons/159993

import java.util.Queue;
import java.util.LinkedList;

/*
 * 시작 위치에서 레버까지, 레버 위치에서 출구까지를 별도로 계산하면 되는 BFS문제입니다.
 * 이미 지났던 길을 다시 가도 된다고 하지만, 최단거리를 가려면 그럴 이유가 없습니다.
 * 단, 레버까지 가면서 지났던 길은 출구로 가면서 다시 갈 수도 있으므로 두 BFS는 독립적입니다.
 */

class Solution7 {
    String[] maps;
    
    public int solution(String[] maps) {
        this.maps = maps;
        int sI = 0;
        int sJ = 0;
        int lI = 0;
        int lJ = 0;
        int eI = 0;
        int eJ = 0;
        
        for (int i = 0; i < maps.length; i++) { // 시작점, 끝점, 레버위치 기록
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    sI = i;
                    sJ = j;
                }
                else if (c == 'E') {
                    eI = i;
                    eJ = j;
                }
                else if (c == 'L') {
                    lI = i;
                    lJ = j;
                }
            }
        }
        
        int leverDist = bfs(sI, sJ, lI, lJ); // 레버까지 거리 BFS로 구하기
        
        if (leverDist == -1) { // 도달할 수 없으면 -1 반환
            return -1;
        }
        
        int endDist = bfs(lI, lJ, eI, eJ); // 레버에서 끝까지 거리 BFS로 구하기
        
        if (endDist == -1) { // 도달할 수 없으면 -1 반환
            return -1;
        }
        
        return leverDist + endDist; // 두 거리의 합 반환
    }
    
    int bfs(int startI, int startJ, int targetI, int targetJ) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[maps.length][maps[0].length()];
        
        for (int i = 0; i < distance.length; i++) { // 거리를 -1로 초기화 (방문하지 않았다는 의미)
            for (int j = 0; j < distance[0].length; j++) {
                distance[i][j] = -1;
            }
        }
        
        queue.offer(new int[]{startI, startJ});
        distance[startI][startJ] = 0;
        
        while (!queue.isEmpty()) { // BFS
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];
            
            if (i == targetI && j == targetJ) { // 타겟에 도착하면 종료
                return distance[i][j]; // 타겟까지의 거리를 반환
            }
            
            if (i > 0 && maps[i-1].charAt(j) != 'X' && distance[i-1][j] == -1) { // 이동 가능하고 방문하지 않았으면 거리 계산 & 큐에 넣기
                distance[i-1][j] = distance[i][j] + 1;
                queue.offer(new int[]{i-1, j});
            }
            if (j > 0 && maps[i].charAt(j-1) != 'X' && distance[i][j-1] == -1) {
                distance[i][j-1] = distance[i][j] + 1;
                queue.offer(new int[]{i, j-1});
            }
            if (i < maps.length-1 && maps[i+1].charAt(j) != 'X' && distance[i+1][j] == -1) {
                distance[i+1][j] = distance[i][j] + 1;
                queue.offer(new int[]{i+1, j});
            }
            if (j < maps[0].length()-1 && maps[i].charAt(j+1) != 'X' && distance[i][j+1] == -1) {
                distance[i][j+1] = distance[i][j] + 1;
                queue.offer(new int[]{i, j+1});
            }
            
        }
        
        return -1;
    }
}