# https://school.programmers.co.kr/learn/courses/15008/lessons/121685

# 재귀적으로 트리를 타고 올라가야 하는 문제입니다.
# 자식에서 부모로 타고 올라갈 때 n과 p가 어떻게 변화하는지 잘 이해해 봅시다.


CHEAT_SHEET = { # 부모 별로 자식들을 미리 입력
    'Rr': ['RR', 'Rr', 'Rr', 'rr'],
    'RR' : ['RR', 'RR', 'RR', 'RR'],
    'rr' : ['rr', 'rr', 'rr', 'rr']
}

def solution(queries):
    def recursive(i, j):
        if i == 1: # root node는 Rr
            return 'Rr'        
        return CHEAT_SHEET[recursive(i-1, j // 4)][j % 4] # 부모 노드는 항상 j/4 위치, 자식 노드는 4로 나눈 나머지 위치
    
    answer = []
    for n, p in queries:
        answer.append(recursive(n, p-1)) # 1-based index를 0-based index로 변경
    
    return answer
