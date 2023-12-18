# https://school.programmers.co.kr/learn/courses/15008/lessons/121684

# DFS를 이용한 정석적인 순열 문제입니다.
# 순열을 완전 탐색하면서 가장 좋은 경우를 찾아내면 됩니다.


def solution(ability):
    answer = 0
    num_student = len(ability)
    num_category = len(ability[0])
    
    def dfs(score, j, status):
        nonlocal answer
        
        if sum(status) == num_category: # 모든 종목에 학생을 다 배정한 경우
            answer = max(answer, score) # 정답을 업데이트하고 종료
            return
    
        for i in range(num_student):
            if status[i] == 1: # 이미 다른 종목에 참가한 학생은 패스
                continue
            
            status[i] = 1
            dfs(score + ability[i][j], j+1, status) # 현재 학생을 현재 종목에 참가시키고 진행
            status[i] = 0
    
    curr_status = [0 for _ in range(num_student)] # 학생이 중복 참여할 수 없으므로, 중복을 방지하기 위한 상태 배열
    dfs(0, 0, curr_status) # 능력총합0, 0번째 종목부터 시작
    
    return answer
