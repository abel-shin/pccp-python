package prob1;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121683

import java.util.*;
import java.util.stream.*;

/*
 * 주어진 조건에 맞는 출력을 계산하는 구현문제입니다.
 * 다양한 방법으로 구현할 수 있습니다. 각자 편한 방법으로 빠르고 정확하게 구현해 봅시다.
 */


class Solution {
    public String solution(String input_string) {
        Map<Character, Integer> counter = new HashMap<>(); // 알파벳 문자 별 개수를 저장할 맵
        List<String> answerList = new ArrayList<>(); // 정답에 해당하는 알파벳을 모을 리스트
        
        for (char c: input_string.toCharArray()) { // 알파벳 별로 개수를 카운트합니다.
            if (!counter.containsKey(c)) {
                counter.put(c, 0);
            }
            counter.put(c, counter.get(c) + 1);
        }
        
        for (char c: counter.keySet()) {
            StringBuilder sb = new StringBuilder(); // 알파벳 개수만큼 이어 붙인 문자열을 만듭니다 ex) a 3개 -> aaa
            for (int i = 0; i < counter.get(c); i++) {
                sb.append(c);
            }
            if (!input_string.contains(sb.toString())) { // 위에서 만든 문자열이 input_string에 있는지 검사합니다.
                answerList.add(String.valueOf(c));       // 위에서 만든 문자열이 없으면 "외톨이 문자열"이므로 추가
            }
        }
        
        if (answerList.isEmpty()) {
            return "N";
        } else {
            return answerList.stream()
                            .sorted()
                            .collect(Collectors.joining(""));
        }
    }
}