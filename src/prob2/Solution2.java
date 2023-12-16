package prob2;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121688

import java.util.*;

/*
 * 그리디 문제입니다.
 * 매 회차마다 가장 능력이 작은 두 사원을 뽑으면 됩니다.
 * 이를 가장 쉽게 구현하기 위해서는 Heap을 이용해 주면 됩니다.
 */

class Solution2 {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val: ability) {
            pq.offer(val);
        }

        for (int i = 0; i < number; i++) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b);
            pq.offer(a + b);
        }

        return pq.stream().mapToInt(i->i).sum();
    }
}
