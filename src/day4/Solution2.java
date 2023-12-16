package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/154538

import java.util.Queue;
import java.util.LinkedList;

/*
 * DFS문제처럼 보이지만, 그렇게 접근하면 완전탐색을 해야 하므로 시간 초과 발생
 * x -> y로 변환하는게 아닌, y -> x로 역변환하면서 BFS로 최단거리 계산
 * Queue를 이용한 BFS에 익숙해질 필요가 있습니다!
 */

class Solution2 {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{y, 0}); // y값에서 시작, 연산 횟수는 0부터 시작
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int v = q[0];
            int i = q[1];
            
            if (v < x) { // 값이 x보다 작아졌으면 더이상 진행하지 않음 (3가지 동작을 아무리 계속해도 x가 될 수 없음)
                continue;
            }
            
            if (v == x) { // 값이 일치하면 그대로 종료
                return i; // 연산 횟수를 반환
            }
            
            if (v % 3 == 0) { // 3으로 나누어 떨어질 경우, 3으로 나누는 역변환 가능
                queue.offer(new int[]{v/3, i+1});
            }
            if (v % 2 == 0) { // 2로 나누어 떨어질 경우, 2로 나누는 역변환 가능
                queue.offer(new int[]{v/2, i+1});
            }
            queue.offer(new int[]{v-n, i+1}); // n을 빼는 역변환은 언제나 가능
        }
        
        return -1; // BFS가 끝나도 방법을 찾지 못하면 -1 반환
    }
}