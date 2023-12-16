package day5;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/43163

/*
 * 단어를 하나씩 타고 다니면서 변환하는 그래프 문제입니다.
 * BFS로 접근하면 가장 빨리 target에 도달하는 경우를 찾을 수 있습니다.
 * 문자가 하나만 다르면 두 문자열은 인접한 노드가 되는 점을 이용해 구현해 봅시다.
 */


class Solution2 {
    public int solution(String begin, String target, String[] words) {
        Set<String> visited = new HashSet<>(); // 이미 접근한 단어를 저장하기 위한 Hash Set
        Queue<Item> queue = new LinkedList<>(); // BFS를 수행하기 위한 Queue (단어와 depth를 함께 저장)
        
        queue.offer(new Item(begin, 0));
        
        while (!queue.isEmpty()) {
            Item q = queue.poll();
            if (q.word.equals(target)) {
                return q.depth;
            }
            
            if (visited.contains(q.word)) {
                continue;
            }
            visited.add(q.word);
            
            for (String word: words) {
                if (isAdjacent(word, q.word)) {
                    queue.offer(new Item(word, q.depth+1));
                }
            }
            
        }
 
        return 0;
    }
 
    boolean isAdjacent(String x, String y) { // 문자가 한개만 다를 경우 인접한 단어
        int count = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                count++;
 
                if (count >= 2) {
                    return false;
                }
            }
        }
 
        return true;
    }
}

class Item {
    String word;
    int depth;
    
    Item(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }
}