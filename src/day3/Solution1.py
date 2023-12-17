# https://school.programmers.co.kr/learn/courses/30/lessons/12909

# 스택을 이용하는 괄호 짝 맞추기 문제입니다.
# 스택이 사용되는 가장 기초적인 예제이므로 꼭 잘 익혀둡시다.
 

def solution(s):
    if len(s) % 2 > 0: # 괄호의 개수가 홀수이면 무조건 false
        return False
    
    stack = []
    
    for c in s:
        if c == '(': # 여는 괄호는 스택에 넣는다.
            stack.append(c)
        else: # 닫는 괄호가 나올때 마다 스택에서 하나씩 꺼낸다.
            if not stack: # 스택이 비어있으면 짝이 맞지 않으므로 false
                return False
            else:
                stack.pop()
    
    if stack: # 문자열 전체를 다 처리 하고 스택이 비어 있어야 짝이 맞다.
        return False
    
    return True
