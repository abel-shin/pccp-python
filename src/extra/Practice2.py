# 피보나치 수열을 DP로 구현하세요.
# Top-Down 방식, Bottom-Up 방식 중에 선택하여 구현하세요.


def fibonacci_dp_topdown(n):
    dp = [-1 for _ in range(n+1)]
    dp[0] = 1
    dp[1] = 1

    def solve(n):
        if dp[n] != -1:
            return dp[n]
        dp[n] = solve(n-1) + solve(n-2)
        return dp[n]

    return solve(n)


def fibonacci_dp_bottomup(n):
    dp = [-1 for _ in range(n+1)]
    dp[0] = 1
    dp[1] = 1
    for i in range(2, n+1):
        dp[i] = dp[i-1] + dp[i-2]
    return dp[n]


if __name__ == '__main__':
    print(fibonacci_dp_topdown(20))
    print(fibonacci_dp_bottomup(20))
