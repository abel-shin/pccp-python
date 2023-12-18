# https://school.programmers.co.kr/learn/courses/30/lessons/42898

# 2차원 지도에 적용하는 DP 문제입니다.
# DP[i][j] : (i, j)에 도달하는 방법의 수
# 점화식: DP[i][j] = DP[i-1][j] + DP[i][j-1]


def solution(m, n, puddles):
    board = [[False] * (n+1) for _ in range(m+1)]
    for i, j in puddles:
        board[i][j] = True
        
    dp = [[0] * (n+1) for _ in range(m+1)]
    for i in range(1, m+1):
        for j in range(1, n+1):
            if i == 1 and j == 1: # DP[1][1] = 1
                dp[i][j] = 1
            elif board[i][j]: # 물웅덩이가 있으면 도달 방법 없음
                dp[i][j] = 0
            else: # 점화식
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007
    
    return dp[m][n]
