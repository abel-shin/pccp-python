package day5;

// https://school.programmers.co.kr/learn/courses/30/lessons/12935

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
 * 가볍게 풀 수 있는 구현 문제입니다.
 * 이런 문제는 생산성 있게 빠르고 정확하게 해결하도록 연습합시다!
 */

class Solution4 {
    public int[] solution(int[] arr) {
        int minVal = Arrays.stream(arr).min().getAsInt(); // one-line 최소값 구하기
        
        List<Integer> list = new ArrayList<>();
        
        for (int val: arr) { // 향상된 for문을 이용한 빠른 구현
            if (val != minVal) {
                list.add(val);
            }
        }
        
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(i->i).toArray(); // 삼항 연산자와 스트림을 이용한 빠른 구현
    }
}