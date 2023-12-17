# https://school.programmers.co.kr/learn/courses/30/lessons/12952

# 기본적인 백트래킹 문제인 N-Queen 문제입니다.
# 유망한지 아닌지를 판단하는 로직이 가장 중요합니다.
 

def solution(n):
    answer = 0
    
    def dfs(arr): # i번째 퀸을 추가하는 동작을 합니다.
        nonlocal answer
        
        def is_promising(j):
            res = True
            for i in range(len(arr)): # 이전의 모든 퀸과 비교
                if arr[i] == j: # 직선 자리에 있으면 유망하지 않음
                    res = False
                    break
                if abs(arr[i] - j) == len(arr) - i: # 대각선 자리에 있으면 유망하지 않음
                    res = False
                    break            
            return res
        
        if len(arr) == n:  #  n개의 퀸을 모두 채웠으므로 카운트
            answer += 1
            return
        
        for j in range(n):
            if is_promising(j): # 다음 퀸을 j번째 자리에 놓는 것이 유망한지 판단
                arr.append(j)
                dfs(arr)
                arr.pop()
        
    dfs([])
    
    return answer
