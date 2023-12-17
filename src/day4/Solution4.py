# https://school.programmers.co.kr/learn/courses/30/lessons/43164

# 문자열로 구성된 노드를 다뤄야 하는 백트래킹 DFS 문제입니다.
# 문자열에 겁먹지 말고, 모든 티켓을 사용하는 방법을 전수조사 하면 됩니다.


def solution(tickets):
    answers = []
    ticket_used = [False] * len(tickets)
    
    def dfs(depth, curr, path):
        if depth == len(tickets):
            answers.append(path)
            return
        
        for i in range(len(tickets)):
            if not ticket_used[i] and curr == tickets[i][0]:
                ticket_used[i] = True
                dfs(depth+1, tickets[i][1], path + ' ' + tickets[i][1])
                ticket_used[i] = False
    
    dfs(0, 'ICN', 'ICN')
    answers.sort()    
    return answers[0].split(' ')
