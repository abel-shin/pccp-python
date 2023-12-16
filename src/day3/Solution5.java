package day3;

// https://school.programmers.co.kr/learn/courses/30/lessons/12946

import java.util.List;
import java.util.ArrayList;

/*
 * 재귀 구현의 기본이자 넘어야 할 벽, 하노이의 탑입니다.
 * 점화식과 종료조건을 정확하게 이해하고 구현해 봅시다.
 * 덤으로 List와 Array를 넘나드는 구현에 익숙해져 봅시다.
 */

class Solution5 {
    public int[][] solution(int n) {
        List<int[]> result = hanoi(1, 3, 2, n);
        return result.stream().toArray(int[][]::new); // List를 Array로 변환할 때에는 stream을 쓰면 편리
    }
    
    List<int[]> hanoi(int start, int end, int support, int n) {
        if (n == 1) { // 종료 조건
            List<int[]> result = new ArrayList<>();
            result.add(new int[]{start, end});
            return result;
        }
        
        List<int[]> result = hanoi(start, support, end, n-1); // 상단 n-1개를 support로 이동
        result.add(new int[]{start, end}); // 최하단 1개를 end로 이동
        result.addAll(hanoi(support, end, start, n-1)); // 상단 n-1개를 end로 이동
        return result;        
    }
}