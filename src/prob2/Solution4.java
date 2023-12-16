package prob2;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121690

import java.util.*;

/*
 * BFS를 이용한 최단 거리 문제입니다.
 * 신비로운 신발을 사용한 경우와 사용하지 않은 경우를 나누어 visited를 생성하는 것이 핵심입니다.
 */

class Solution4 {
    public int solution(int n, int m, int[][] hole) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] board = new int[n][m]; // 구멍이 있으면 1, 없으면 0
        for (int[] h: hole) {
            board[h[0]-1][h[1]-1] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();

        boolean[][][] visited = new boolean[n][m][2]; // 위치별, 신발 사용 여부별 노드 방문 여부
        visited[0][0][0] = true;
        queue.offer(new int[]{0, 0, 0});
        int answer = 0;

        while (!queue.isEmpty()) {
            int N = queue.size();
            for (int i = 0; i < N; i++) { // 한 번 이동하는 모든 방법 확인
                int[] val = queue.remove();
                int x = val[0];
                int y = val[1];
                int used = val[2];

                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (0 <= newX && newX < n && // 새 위치가 보드를 벗어나는지 여부
                        0 <= newY && newY < m &&
                        !visited[newX][newY][used] && // 새 위치의 방문 여부
                        board[newX][newY] == 0) { // 새 위치에 구멍이 있는지 여부
                            if (newX == (n-1) && newY == (m-1)) { // 보물에 도착시 종료
                                return answer + 1;
                            }
                            visited[newX][newY][used] = true;
                            queue.offer(new int[]{newX, newY, used});
                    }
                    if (used == 0) { // 신발을 사용하지 않았을 경우 사용하는 경우도 탐색
                        newX += dx[j]; // 같은 방향으로 한칸 더 움직임
                        newY += dy[j];
                        if (0 <= newX && newX < n && 
                            0 <= newY && newY < m &&
                            !visited[newX][newY][1] &&
                            board[newX][newY] == 0) {
                            if (newX == (n-1) && newY == (m-1)) {
                                return answer + 1;
                            }
                            visited[newX][newY][1] = true;
                            queue.offer(new int[]{newX, newY, 1});
                        }
                    }
                }
            }
            answer++;
        }

        return -1;
    }
}