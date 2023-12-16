package day3;

// https://school.programmers.co.kr/learn/courses/30/lessons/42584

import java.util.Deque;
import java.util.ArrayDeque;

/*
 * 스택을 이용하는 조금 더 어려운 예제입니다.
 * 한번에 하나씩 짝을 맞추는 것이 아닌, 조건에 맞는 여러개의 짝을 맞춥니다.
 * 가격이 상승할 때에는 스택에 추가하고,
 * 가격이 하락하면 더 높은 가격을 모두 짝을 맞추어 주는 형식으로 구현합니다.
 */

class Solution2 {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) { // 가격이 top보다 하락한 동안 pop
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i); // pop 과정이 모두 끝나면 새로운 값을 push
        }
        
        while (!stack.isEmpty()) { // 마지막까지 가격이 떨어지지 않은 인덱스 처리
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        
        return answer;        
    }
}