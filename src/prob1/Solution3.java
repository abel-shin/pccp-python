package prob1;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121685

import java.util.*;

/*
 * 재귀적으로 트리를 타고 올라가야 하는 문제입니다.
 * 자식에서 부모로 타고 올라갈 때 n과 p가 어떻게 변화하는지 잘 이해해 봅시다.
 */


class Solution3 {
    Map<String, String[]> cheatSheet;
    
    public String[] solution(int[][] queries) {
        cheatSheet = new HashMap<>(); // 부모 별로 자식들을 미리 입력
        cheatSheet.put("Rr", new String[]{"RR", "Rr", "Rr", "rr"});
        cheatSheet.put("RR", new String[]{"RR", "RR", "RR", "RR"});
        cheatSheet.put("rr", new String[]{"rr", "rr", "rr", "rr"});
        
        String[] answer = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0] - 1; // 1-based index를 0-based index로 변경
            int p = queries[i][1] - 1; // 1-based index를 0-based index로 변경
            answer[i] = recursive(n, p);
        }
        
        return answer;
    }
    
    String recursive(int i, int j) {
        if (i == 0) { // root node는 Rr
            return "Rr";
        }
        
        String parent = recursive(i-1, j/4); // 부모 노드는 항상 j/4 위치
        return cheatSheet.get(parent)[j%4]; // 자식 노드는 4로 나눈 나머지 위치
    }
}