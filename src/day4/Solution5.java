package day4;


// https://school.programmers.co.kr/learn/courses/30/lessons/84512

/*
 * 사전식 순서를 세는 문제입니다.
 * 사전식 순서는 DFS를 이용하면 순서대로 나열할 수 있습니다.
 * 또한, 원하는 단어를 찾은 후에는 더 이상 세지 않도록
 * 백트래킹을 적용해 주어야 합니다.
 */


class Solution5 {
    String[] words = {"A", "E", "I", "O", "U"};
    int answer = 0;
    int n;
    String word;
    boolean isDone = false;
    
    public int solution(String word) {
        n = word.length();
        this.word = word;

        dfs("");
        
        return answer;
    }

    void dfs(String curr) {
        if (isDone) {
            return;
        }


        if (!curr.isEmpty()) {
            answer++;
        }
        
        if (curr.equals(word)) {
            isDone = true;
            return;
        }

        if (curr.length() == 5) {
            return;
        }

        for (String s: words) {
            dfs(curr + s);
        }
    }
}