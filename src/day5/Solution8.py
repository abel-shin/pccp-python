# https://school.programmers.co.kr/learn/courses/30/lessons/92343

# DFS를 이용한 완전 탐색 문제입니다.
# 탐색의 기준이 현재 노드가 아닌, 지금까지 탐색한 모든 노드의 자식이 됩니다.
# 늑대와 양의 수가 같아지면 해당 방향으로는 더이상 탐색하지 않습니다.


def solution(info, edges):
    answer = 0
    
    def dfs(curr, sheep, wolf, children):
        nonlocal answer
        
        if info[curr] == 0: # 양/늑대의 수 업데이트
            sheep += 1
        else:
            wolf += 1
        
        if sheep <= wolf: # 늑대가 양을 잡아먹는 상황이면 진행 불가
            return
        
        answer = max(answer, sheep) # 가능한 최대 양의 수 업데이트
        
        for child in adj[curr]: # 현재 방문중인 노드의 모든 자식 추가
            children.add(child)
        
        children_copy = children.copy()
        for child in children_copy:
            children.remove(child) # 새로 방문하는 노드는 제거(제거하지 않으면 무한히 자기 자신을 방문)
            dfs(child, sheep, wolf, children) # 새로운 노드 방문
            children.add(child) # 제거한 새로 방문하는 노드 되살리기
        
        for child in adj[curr]: # 앞서 추가한 현재 방문중인 노드의 자식 제거
            children.remove(child)
    
    adj = [set() for _ in range(len(info))] # 인접 리스트로 변환 (여기서는 List 대신 Set을 사용)
    for e in edges:
        adj[e[0]].add(e[1])
    
    children = set(adj[0]) # 탐색한 노드의 모든 자식 노드를 모은 셋
    dfs(0, 0, 0, children)
    return answer
