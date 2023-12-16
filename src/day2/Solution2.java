package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.Arrays;

/*
 * 우선, 정렬 문제인지 알아채는 것이 중요한 문제입니다.
 * 문자열을 이어붙이는 순서에 따라 어떤 방법이 더 큰 수를 만드는지 비교하여 정렬합니다.
 */

class Solution2 {
    public String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers)
                            .boxed()
                            .map(i->String.valueOf(i)) // 숫자를 문자열로 변환합니다.
                            .sorted((a, b) -> { // 문자열을 이어 붙이는 순서를 달리하여 만들어진 숫자의 크기를 비교하여 정렬
                                int x = Integer.valueOf(a+b);
                                int y = Integer.valueOf(b+a);
                                return y - x; // 내림차순으로 정렬
                            }).toArray(String[]::new);
        
        String answer = String.join("", nums); // 정렬된 배열을 join하여 최종 출력
        return answer.charAt(0) == '0' ? "0" : answer; // leading-zero가 있는 경우 배열의 모든 입력이 0인 경우이므로, 0으로 값을 대체합니다.
    }
}