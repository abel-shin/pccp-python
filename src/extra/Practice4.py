# 0-1 Knapsack Problem을 해결하세요.
# Bottom-Up(Tabulation) 방법을 사용하면 구현할 수 있습니다.


def solution(W, V, C):
    N = len(W)
    dp = [[0]*(C+1) for _ in range(N+1)]

    for i in range(N):
        for w in range(C+1):
            if w >= W[i]:
                dp[i+1][w] = max(dp[i][w], dp[i][w-W[i]] + V[i])
            else:
                dp[i+1][w] = dp[i][w]

    return dp[N][C]


if __name__ == '__main__':
    W = [4, 5, 2, 5, 6, 3]
    V = [4, 1, 4, 5, 6, 9]
    C = 18
    print(solution(W, V, C))
