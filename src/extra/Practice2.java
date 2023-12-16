package extra;

import java.util.Arrays;

/*
 * 피보나치 수열을 DP로 구현하세요.
 * Top-Down 방식, Bottom-Up 방식 중에 선택하여 구현하세요.
 */

class Practice2 {
    int[] dp;

    int fibonacci_dp_topdown(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        return solve(n);
    }

    int solve(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = solve(n-1) + solve(n-2);
        return dp[n];
    }


    int fibonacci_dp_bottomup(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Practice2().fibonacci_dp_topdown(20));
        System.out.println(new Practice2().fibonacci_dp_bottomup(20));
    }
}