package extra;

// https://school.programmers.co.kr/learn/courses/30/lessons/42898


/*
 * 2차원 지도에 적용하는 DP 문제입니다.
 * DP[i][j] : (i, j)에 도달하는 방법의 수
 * 점화식: DP[i][j] = DP[i-1][j] + DP[i][j-1]
 */

class Solution1 {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] board = new boolean[m+1][n+1];
        for (int[] puddle: puddles) {
            board[puddle[0]][puddle[1]] = true;
        }
        
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i == 1 && j == 1) { // DP[1][1] = 1
                    dp[i][j] = 1;
                }
                else if (board[i][j]) { // 물웅덩이가 있으면 도달 방법 없음
                    dp[i][j] = 0;
                } else { // 점화식
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
                }
            }
        }
        
        return dp[m][n];
    }
}