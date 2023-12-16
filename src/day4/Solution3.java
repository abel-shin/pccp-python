package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/12952

/*
 * 기본적인 백트래킹 문제인 N-Queen 문제입니다.
 * 유망한지 아닌지를 판단하는 로직이 가장 중요합니다.
 */

class Solution3 {
    int n;
    int[] arr;
    int answer = 0;
    
    
    public int solution(int n) {
        this.n = n;
        arr = new int[n];
        dfs(0);
        return answer;
    }
    
    void dfs(int i) { // i번째 퀸을 추가하는 동작을 합니다.
        if (i == n) { // n개의 퀸을 모두 채웠으므로 카운트
            answer++;
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (isPromising(i, j)) { // i번째 퀸을 j번째 자리에 놓는 것이 유망한지 판단
                arr[i] = j;
                dfs(i+1);
            }
        }
    }
    
    boolean isPromising(int i, int j) {
        boolean res = true;
        
        for (int k = 0; k < i; k++) { // 이전의 모든 퀸과 비교
            if (arr[k] == j) { // 직선 자리에 있으면 유망하지 않음
                res = false;
                break;
            }
            if (Math.abs(arr[k] - j) == i - k) { // 대각선 자리에 있으면 유망하지 않음
                res = false;
                break;
            }
        }
        return res;
    }
}