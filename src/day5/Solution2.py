# https://school.programmers.co.kr/learn/courses/30/lessons/43163

# 단어를 하나씩 타고 다니면서 변환하는 그래프 문제입니다.
# BFS로 접근하면 가장 빨리 target에 도달하는 경우를 찾을 수 있습니다.
# 문자가 하나만 다르면 두 문자열은 인접한 노드가 되는 점을 이용해 구현해 봅시다.


def solution(begin, target, words):
    visited = set() # 이미 접근한 단어를 저장하기 위한 Hash Set
    queue = [] # BFS를 수행하기 위한 Queue (단어와 depth를 함께 저장)
    
    def is_adjacent(x, y): # 문자가 한개만 다를 경우 인접한 단어
        count = 0
        for x_, y_ in zip(x, y):
            if x_ != y_:
                count += 1
            
            if count >= 2:
                return False
        
        return True
    
    queue.append((begin, 0))
    while queue:
        word, depth = queue.pop(0)
        
        if word == target:
            return depth
        
        if word in visited:
            continue
        visited.add(word)
        
        for w in words:
            if is_adjacent(w, word):
                queue.append((w, depth+1))
        
    return 0
