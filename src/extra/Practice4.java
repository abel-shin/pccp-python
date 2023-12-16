package extra;

/*
 * 0-1 Knapsack Problem을 해결하세요.
 * Bottom-Up(Tabulation) 방법을 사용하면 구현할 수 있습니다.
 */

class Practice4 {
    int solution(int[] W, int[] V, int C) {
        int N = W.length;
        int[][] dp = new int[N+1][C+1];

        for (int i = 0; i < N; i++) {
            for (int w = 0; w < C+1; w++) {
                if (w >= W[i]) {
                    dp[i+1][w] = Math.max(dp[i][w], dp[i][w-W[i]] + V[i]);
                } else {
                    dp[i+1][w] = dp[i][w];
                }
            }
        }
        return dp[N][C];
    }

    public static void main(String[] args) {
        int[] W = {4, 5, 2, 5, 6, 3};
        int[] V = {4, 1, 4, 5, 6, 9};
        int C = 18;
        System.out.println(new Practice4().solution(W, V, C));
    }
}