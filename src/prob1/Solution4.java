package prob1;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121686

import java.util.*;

/*
 * PriorityQueue(Heap)을 이용하는 문제입니다.
 * 구현이 까다로운 문제이기 때문에, 답안을 참고하여 놓치지 않고 구현해 보세요!
 * 
 * 코드 참고: https://velog.io/@soluinoon/PCCP-%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC-1%ED%9A%8C-4%EB%B2%88-%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9CJAVA
 */

class Solution {
    static long[] answer = new long[11];
    
    public long[] solution(int[][] program) {
        // [프로그램 점수(우선순위), 호출시각, 실행시간]
        // 웨이트 힙은 우선순위 순서로 대기시킵니다.
        PriorityQueue<int[]> waitHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        // 슬립 힙은 호출시각 순서로 대기시킵니다.
        PriorityQueue<int[]> sleepHeap = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        for (int i = 0; i < program.length; i++) {
            sleepHeap.add(program[i]);
        }
        
        run(waitHeap, sleepHeap);
        
        return answer;
    }
    
    public void run(PriorityQueue<int[]> waitHeap, PriorityQueue<int[]> sleepHeap) {
        long currTime = -1;
        int runTime = 0;
        while (true) {
            // 슬립힙과 웨잇힙이 둘 다 비었고, 실행이 0이라면 끝난 것 입니다.
            if (waitHeap.isEmpty() && sleepHeap.isEmpty() && runTime == 0) {
                break;
            }
            currTime++;
            // 실행 중 이라면 감소, 즉 0이라면 실행 중 아님.
            if (runTime > 0) {
                runTime--;
            }
            
            // 호출
            // 시간이 같다면, 슬립 힙에서 꺼내서 대기열로 넣습니다.
            while (!sleepHeap.isEmpty() && sleepHeap.peek()[1] == currTime) {
                waitHeap.add(sleepHeap.poll());
            }
            
            // 실행
            if (runTime == 0 && !waitHeap.isEmpty()) {
                int[] curProgram = waitHeap.poll();
                // 실행시간에 추가합니다.
                runTime += curProgram[2];
                // 정답에는 실행된 시각 - 대기열에 들어간 시각이 기록됩니다.
                // 주의할 점은 프로그램 별로 저장되는게 아니라 우선순위 별로 기록된다는 것 입니다.
                // ex) 우선순위가 1인 프로그램은 answer[1]에 저장됨.
                answer[curProgram[0]] += currTime - curProgram[1];
            }
        }
        // 0번에는 프로그램의 총 시간이 들어갑니다.
        answer[0] = currTime;
    }
}