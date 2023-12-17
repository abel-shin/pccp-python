# https://school.programmers.co.kr/learn/courses/30/lessons/120921


# 문자열을 비교하는 완전탐색 문제입니다.
# 문자열을 실제로 shift하면서 비교하면 문자열을 매번 생성해야 하므로 비효율적입니다.
# 효율적으로 비교하기 위해 shift한 인덱스를 계산하여 문자 단위로 비교합니다.


def solution (A, B):
    if A == B: # 두 문자열이 일치할 경우 shift는 0
        return 0

    N = len(A)
    for i in range(1, N): # 1부터 N-1까지 shift 여부를 탐색
        is_equal = True
        for j in range(N): # 문자를 하나씩 비교
            if A[j] != B[(i+j) % N]: # shift한 결과에 해당하는 (i+j)%N 인덱스를 사용하여 비교
                is_equal = False
                break # 하나라도 문자가 불일치할 경우 더 이상 비교 불필요
        if is_equal:
            return i
    return -1
