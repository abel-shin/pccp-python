package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238

import java.util.Arrays;

/*
 * 대표적인 이분탐색 문제로, 탐색 범위가 매우 넓은 점에 유의합니다.
 * 심사하는 데에 걸리는 시간을 계산하는 대신, 특정 시간에 심사가 마치는지를 탐색합니다.
 * 탐색 범위를 전체 범위로 하지 않고, 적절히 최적화 하는 것도 중요합니다.
 */

class Solution5 {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long)Arrays.stream(times).min().getAsInt() * n; // 탐색 범위 최적화 (1명이 혼자 다 처리한다는 가정)
        
        
        while (left < right) { // 이분 탐색 루프
            long mid = left + (right - left) / 2; 
            
            long total = 0;
            for (int time: times) { // mid 시간동안 몇 명 가능한지 계산
                total += mid / time;
            }
            
            if (total >= n) { // 현재 인원 이상 심사할 수 있으면 왼쪽을 선택
                right = mid;
            } else { // 현재 인원 이상 심사할 수 없으면 오른쪽을 선택
                left = mid + 1;
            }
        }
        
        return right;
    }
}