package day3;

// https://school.programmers.co.kr/learn/courses/30/lessons/60058

import java.util.Deque;
import java.util.ArrayDeque;

/*
 * 재귀 구현만 잘 할 수 있으면 풀이할 수 있는 문제입니다.
 * 재귀의 기본에 집중하면서 정확하게 구현해 봅시다.
 */

class Solution6 {
    public String solution(String p) {
        return solve(p);
    }
    
    String solve(String w) {
        int left = 0;
        int right = 0;
        int splitI = 0;
        
        if (w.length() == 0) {
            return w;
        }
        
        for (int i = 0; i < w.length(); i++) { // 균형잡힌 문자열 u를 찾는다.
            if (w.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left > 0 && left == right) {
                splitI = i;
                break;
            }
        }
        
        String u = w.substring(0, splitI + 1);
        String v = w.substring(splitI + 1);
        
        if (isCorrect(u)) { // u가 올바른 문자열이면, v를 재귀 호출한다.
            return u + solve(v);
        } else { // u가 올바른 문자열이 아니면, 주어진 조건대로 동작한다.
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solve(v));
            sb.append(")");
            
            for (int i = 1; i < u.length()-1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            return sb.toString();
        }
    }
    
    boolean isCorrect(String s) { // 스택을 이용하면 올바른 문자열인지 확인할 수 있다.
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}