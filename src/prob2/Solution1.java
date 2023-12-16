package prob2;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121687

/*
 * 간단한 구현/시뮬레이션 문제입니다.
 * 2차원 맵에서 위치와 방향을 기억하는 방식을 잘 확인해 주세요.
 */

class Solution1 {
    public int[] solution(String command) {
        int dir = 0; // 현재 방향(위쪽)
        int[] answer = {0, 0}; // 현재 위치
        int[][] front = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 방향별 정면 이동 위치

        for (char c: command.toCharArray()) {
            if (c == 'R') {
                dir = (dir + 1) % 4;
            } else if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'G') {
                answer[0] += front[dir][0];
                answer[1] += front[dir][1];
            } else {
                answer[0] -= front[dir][0];
                answer[1] -= front[dir][1];
            }
        }

        return answer;
    }
}