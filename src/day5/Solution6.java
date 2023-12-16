package day5;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265

import java.util.Map;
import java.util.HashMap;

/*
 * 해싱을 이용해 각 경우에 대해 토핑의 수를 빠르게 구하는 문제입니다.
 * 해싱을 사용하지 않으면 매번 토핑을 세 주어야 하므로 O(N^2)이 됩니다.
 * 해싱을 사용하면 토핑을 매번 1개씩 업데이트만 해주면 되므로 O(N)이 됩니다.
 */

class Solution6 {
    public int solution(int[] topping) {
        Map<Integer, Integer> map1 = new HashMap<>(); // 왼쪽 롤케이크의 토핑별 개수
        Map<Integer, Integer> map2 = new HashMap<>(); // 오른쪽 롤케이크의 토핑별 개수
        
        for (int i = 0; i < topping.length; i++) { // 오른쪽 롤케이크에 모든 토핑 추가
            if (!map2.containsKey(topping[i])) {
                map2.put(topping[i], 0);
            }
            map2.put(topping[i], map2.get(topping[i]) + 1);
        }
        
        int answer = 0;
        
        for (int i = 0; i < topping.length - 1; i++) { // 하나씩 왼쪽 롤케이크로 토핑을 옮긴다.
            if (!map1.containsKey(topping[i])) { // 왼쪽 롤케이크에 i번째 토핑 하나 추가
                map1.put(topping[i], 0);
            }
            map1.put(topping[i], map1.get(topping[i]) + 1);
            
            if (map2.get(topping[i]) == 1) { // 오른쪽 롤케이크에서 i번째 토핑 하나 제거
                map2.remove(topping[i]);
            } else {
                map2.put(topping[i], map2.get(topping[i]) - 1);
            }
            
            if (map1.keySet().size() == map2.keySet().size()) { // 토핑의 종류의 수가 같으면 정답으로 카운트
                answer++;
            }
        }
        
        return answer;
    }
}