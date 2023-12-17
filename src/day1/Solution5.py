# https://school.programmers.co.kr/learn/courses/30/lessons/64061

# 주어진 조건대로 충실하게 구현하면 되는 시뮬레이션 문제입니다.
# 기계에서 인형을 뽑으면 기계에서 제거하고,
# 바구니에 인형을 넣을 때 동일 인형이 이미 있는지 확인하면 됩니다.

def solution(board, moves):
    stack = []
    
    count = 0
    for move in moves:
        j = move - 1
        doll = -1
        
        for i in range(len(board)): # 위에서 부터 훑어 내려오면서 인형을 찾는다.
            if board[i][j] != 0: # 인형을 찾으면 해당 인형을 집고, 기계에서 제거
                doll = board[i][j]
                board[i][j] = 0
                break
        
        if doll == -1: # 현재 위치에 인형이 없다면 아무 일도 일어나지 않음
            continue
        
        if stack and stack[-1] == doll: # 최상단에 같은 인형이 있으면 제거
            stack.pop()
            count += 2 # 새로 뽑은 인형까지 같이 제거되는 점에 유의
        else:
            stack.append(doll)
            
    return count
