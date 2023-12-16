package day1;

// https://school.programmers.co.kr/learn/courses/30/lessons/140108

/*
 * 조건에 따라 문자열을 분리하는 문제입니다.
 * 동일 동작을 분리된 문자열에 반복하여 적용하므로, 재귀 호출로 구현하면 쉽습니다.
 */

class Solution2 {
    int count = 0; // 문자열 분리 횟수를 저장하는 변수
    
    public int solution(String s) {
        splitString(s);
        return count;
    }
    
    void splitString(String str) {   
        if (str.length() == 0) { // 빈 문자열이면 더 이상 분리할 수 없다.
            return;
        }
        
        char x = str.charAt(0);
        
        int numX = 1;    // 첫 문자의 등장 횟수
        int numNonX = 0; // 첫 문자와 다른 문자 수
        int splitI = -1; // 문자열을 분리할 인덱스
        for (int i = 1; i < str.length(); i++) {
            if (x == str.charAt(i)) {
                numX++;
            } else {
                numNonX++;
            }
            
            if (numX == numNonX) { // 첫 문자와 다른 문자의 개수가 같으면 분리
                splitI = i;
                break;
            }
        }
        
        count++; // 분리가 발생할 때 count 증가
        if (splitI != -1) { // 더 분리할 문자열이 남아있으면 재귀 호출
            splitString(str.substring(splitI + 1));
        }
    }
}