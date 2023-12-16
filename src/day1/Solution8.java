package day1;

import java.util.List;
import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/12910

/*
 * 주어진 조건대로 충실하게 구현하는 문제입니다.
 * 나누어 떨어지는 수를 모으고, 정렬하는 단순한 과정을 최대한 생산성 있게 구현해봅시다.
 * 최종 배열의 크기가 0인 경우 {-1}을 반환하는 것도 잊지 않고 구현합니다.
 */

class Solution8 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int val: arr) { // 향상된 for문으로 코드 양을 줄였습니다. stream과 filter를 이용할 수도 있습니다.
            if (val % divisor == 0) {
                list.add(val);
            }
        }
        
        int[] answer = list.stream().sorted().mapToInt(i->i).toArray(); // 리스트를 정렬하고 배열로 변환합니다.
        return answer.length > 0 ? answer : new int[]{-1}; // 배열이 빈 경우 {-1}을 생성하여 반환합니다.
    }
}