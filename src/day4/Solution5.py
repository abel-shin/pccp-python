# https://school.programmers.co.kr/learn/courses/30/lessons/84512

# 사전식 순서를 세는 문제입니다.
# 사전식 순서는 DFS를 이용하면 순서대로 나열할 수 있습니다.
# 또한, 원하는 단어를 찾은 후에는 더 이상 세지 않도록
# 백트래킹을 적용해 주어야 합니다.


def solution(word):
    words = ['A', 'E', 'I', 'O', 'U']
    answer = 0
    is_done = False
    
    def dfs(curr):
        nonlocal answer, is_done
        
        if is_done:
            return
        
        if curr:
            answer += 1
        
        if curr == word:
            is_done = True
            return
        
        if len(curr) == 5:
            return
        
        for s in words:
            dfs(curr + s)
    
    dfs('')    
    return answer
