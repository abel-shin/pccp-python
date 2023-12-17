# https://school.programmers.co.kr/learn/courses/30/lessons/60058

# 재귀 구현만 잘 할 수 있으면 풀이할 수 있는 문제입니다.
# 재귀의 기본에 집중하면서 정확하게 구현해 봅시다.
 

def solution(p):
    def solve(w):
        left = 0
        right = 0
        split_i = 0
        
        if not w:
            return w
        
        for i in range(len(w)): # 균형잡힌 문자열 u를 찾는다.
            if w[i] == '(':
                left += 1
            else:
                right += 1
            
            if left > 0 and left == right:
                split_i = i
                break
            
        u = w[:split_i + 1]
        v = w[split_i + 1:]
        
        if is_correct(u):  # u가 올바른 문자열이면, v를 재귀 호출한다.
            return u + solve(v)
        else:  # u가 올바른 문자열이 아니면, 주어진 조건대로 동작한다.
            s = '(' + solve(v) + ')'
            
            for i in range(1, len(u) - 1):
                if u[i] == '(':
                    s += ')'
                else:
                    s += '('
            return s
    
    def is_correct(s): # 스택을 이용하면 올바른 문자열인지 확인할 수 있다.
        stack = []
        
        for c in s:
            if c == '(':
                stack.append(c)
            else:
                if stack:
                    stack.pop()
                else:
                    return False
        
        if stack:
            return False
        
        return True
    
    return solve(p)
