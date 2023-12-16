package extra;

// https://school.programmers.co.kr/learn/courses/30/lessons/42897

/*
 * 첫번째 집과 마지막 집이 붙어있으므로, 두 가지 경우로 나누어 풀어야 한다.
 *    1. 마지막 집을 포기하는 경우
 *    2. 첫번째 집을 포기하는 경우
 * DP[i]: i번째 집까지 털었을 때 훔칠 수 있는 돈
 * 점화식: DP[i] = max(DP[i-2] + money[i], DP[i-1])
 */

class Solution2 {
    public int solution(int[] money) {
        int N = money.length;

        int[] dp1 = new int[N-1]; // 마지막 집을 포기한다는 가정 (총 N-1개의 집만 고려)
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < N-1; i++) {
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
        }
        
        int[] dp2 = new int[N+1]; // 첫번째 집을 포기한다는 가정 (DP[0] = 0)
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < N; i++) {
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }
        
        return Math.max(dp1[N-2], dp2[N-1]);
    }
}