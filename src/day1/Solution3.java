package day1;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.Map;
import java.util.HashMap;

/*
 * 해싱을 이용하여 두 배열을 효율적으로 비교하는 문제입니다.
 * 해싱하지 않고 비교할 경우 시간복잡도는 O(N^2)입니다.
 * 해싱을 하고 비교할 경우 시간 복잡도는 O(N)입니다.
 * 동명이인이 없다면 Set을 이용하여 비교할 수 있겠지만, 동명이인을 고려하여 Map을 이용해서 비교해야 합니다.
 */


class Solution3 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> partMap = new HashMap<>(); // 참가자의 이름-인원 수
        Map<String, Integer> compMap = new HashMap<>(); // 완주자의 이름-인원 수
        
        for (String s: participant) { // 참가자 이름별 인원 수 계산
            if (!partMap.containsKey(s)) {
                partMap.put(s, 0);
            }
            partMap.put(s, partMap.get(s) + 1);
        }
        
        for (String s: completion) { // 완주자 이름별 인원수 계산
            if (!compMap.containsKey(s)) {
                compMap.put(s, 0);
            }
            compMap.put(s, compMap.get(s) + 1);
        }
        
        for (String s: partMap.keySet()) {
            if (!compMap.containsKey(s) || // 참가자 중에 완주자 명단에 없는 경우 
                !partMap.get(s).equals(compMap.get(s))) { // 참가자 수와 완주자 수가 다른 경우
                return s;
            }
        }
        
        return "";
    }
}
