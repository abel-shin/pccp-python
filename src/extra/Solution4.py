# https://school.programmers.co.kr/learn/courses/30/lessons/42627

# 작업의 대기 시간을 최소화 하는 문제입니다.
# 동시에 기다리는 작업 중 더 빨리 끝나는 작업이 우선 끝나야 하므로,
# Heap을 이용하여 작업 시간이 더 짧은 작업부터 처리하면 됩니다.


from heapq import heappop, heappush

def solution(jobs):
    i = 0
    start_time = -1  # 작업이 시작된 시각
    current_time = 0 # 현재 시각
    total_time = 0   # 총 대기 시간
    heap = []
    
    while i < len(jobs):
        for j in jobs: # 작업이 시작한 이래로 대기한 모든 작업 삽입
            if start_time < j[0] <= current_time:
                heappush(heap, [j[1], j[0]]) # 작업시간이 짧은 순으로
        
        if heap: # 처리할 작업이 있으면 처리
            job_time, t = heappop(heap)
            start_time = current_time # 작업 시작 시각 기록
            current_time += job_time  # 작업 처리 시간만큼 시간이 흐름
            total_time += current_time - t # 전체 요청 종료까지 걸린 시간에 기록
            i += 1 # 작업 1개 처리
        else:
            current_time += 1 # 처리할 작업이 없으면 시간을 보낸다.
                
    return total_time // len(jobs)
