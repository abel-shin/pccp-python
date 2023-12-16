package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12915

import java.util.Arrays;

/*
 * 문자열 정렬 조건을 바꾸어 보는 문제입니다.
 * 스트림과 람다식을 이용해 높은 생산성으로 구현하는 데에 집중해 봅시다.
 */

class Solution1 {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings). // 배열에서 스트림을 생성하는 방법입니다.
                sorted((a, b) -> {     // 람다식을 이용해 sorted()메소드에서 정렬 조건을 바로 구현합니다.
                    if (a.charAt(n) == b.charAt(n)) { // n번째 문자가 같으면 기존 방식(사전식 순서)으로 정렬
                        return a.compareTo(b);
                    }
                    return a.charAt(n) - b.charAt(n); // n번째 문자를 기준으로 오름차순으로 정렬.
                }).toArray(String[]::new); // 참조형 객체 배열로 변환할 때에는 생성자를 입력해 주어야 한다.
    }
}