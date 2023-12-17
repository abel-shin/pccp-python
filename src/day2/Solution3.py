# https://school.programmers.co.kr/learn/courses/30/lessons/42862


# 탐욕법으로 풀리는 문제인지 알아채는 것이 중요한 문제입니다.
# 자료가 정렬되었다는 가정 하여 탐욕법이 정해인 경우에 해당합니다.
# 본문에 제시된 대로, 체육복 여벌이 있는데 도난당한 학생은 별도 처리해야 합니다.


def solution(n, lost, reserve):
    answer = n - len(lost) # 잃어버린 학생 수만큼 불참한다고 가정하고 시작
    
    lost.sort() # 정렬을 하지 않으면 빌려주는 기준이 달라져 반례가 발생
    reserve.sort()
    
    for i in range(len(lost)): # 여벌을 가진 학생이 도난당한 경우 별도 처리
        for j in range(len(reserve)):
            if lost[i] == reserve[j]:
                answer += 1
                lost[i] = -1
                reserve[j] = -1 # 이미 빌려준 경우 -1처리
                break
    
    for i in range(len(lost)):
        if lost[i] == -1:
            continue
        
        for j in range(len(reserve)):
            if lost[i] - 1 == reserve[j] or lost[i] + 1 == reserve[j]:
                answer += 1 # 정렬을 해 주었기 때문에, 일정한 기준(더 작은 인덱스 우선)으로 빌려주게 됩니다.
                reserve[j] = -1
                break
    
    return answer
