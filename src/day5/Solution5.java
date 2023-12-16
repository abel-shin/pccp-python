package day5;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129

/*
 * 조건을 적절히 변경하여 구현하면 되는 문제입니다.
 * 0을 실제로 제거하는 대신, 1의 개수만 세면 되는 점에 유의합시다.
 */

class Solution5 {
    public int[] solution(String s) {
        int transCount = 0; // 변환 횟수
        int zeroCount = 0;  // 제거한 0의 개수
        
        while (!s.equals("1")) { // 1이 되기 전까지 반복
            int oneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') { // 1의 개수를 새면 모든 0을 제거한 것과 같다.
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            
            s = Integer.toBinaryString(oneCount); // 1의 개수 = 0을 제거한 후의 자릿수
            transCount++;
        }
        
        return new int[]{transCount, zeroCount};
    }
}