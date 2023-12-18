# https://school.programmers.co.kr/learn/courses/15008/lessons/121686


# PriorityQueue(Heap)을 이용하는 문제입니다.
# 구현이 까다로운 문제이기 때문에, 답안을 참고하여 놓치지 않고 구현해 보세요!

# 코드 참고: https://dmaolon00.tistory.com/entry/ProgrammersPython-%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9C


import heapq
 
def solution(programs):
    time = 0
    programs.sort(key = lambda x : (x[1], x[0]))  # 호출된 시각을 우선으로 정렬
    idx = 0
    waiting = []
    answer = [0 for _ in range(10)]
    program = []
    
    while idx < len(programs) or waiting: # 남은 프로그램이 있거나, 대기중인 프로그램이 있으면 동작
        if not waiting: # 대기중인 프로그램이 없으면 현재 프로그램 대기
            time = programs[idx][1]
            while idx != len(programs) and programs[idx][1] <= time:
                heapq.heappush(waiting, programs[idx]) # 프로그램 실행중인 동안 모든 프로그램 대기
                idx += 1

        program = heapq.heappop(waiting) # 대기중인 프로그램 하나 실행
        answer[program[0] - 1] += time - program[1] # 대기한 만큼 시간 정답에 가산
        time += program[2] # 프로그램 실행만큼 시간 진행

        while idx != len(programs) and programs[idx][1] <= time:
            heapq.heappush(waiting, programs[idx]) # 프로그램 실행중인 동안 모든 프로그램 대기
            idx += 1

    return [time] + answer # 전체 실행시간 덧붙여서 정답 반환
