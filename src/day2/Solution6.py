# https://school.programmers.co.kr/learn/courses/30/lessons/43236

# 난이도가 있는 이분탐색 문제입니다.
# 제거할 바위를 고정하고 바위 사이의 거리의 최솟값을 구하는 대신,
# 바위 사이의 거리의 최솟값을 고정하고 위배되는 바위를 제거하는 방식으로 탐색
# 시작지점과 끝지점도 고려해야 하지만, 이 두 지점은 바위와 달리 제거할 수 없는 점 고려


def solution(distance, rocks, n):
    left = 0
    right = distance
    answer = 0
    
    rocks.sort()
    
    while left <= right:
        mid = (left + right) // 2
        
        count = 0
        last_rock = 0 # 시작 지점을 0으로 설정
        for rock in rocks:
            if rock - last_rock < mid: # 마지막 바위와의 거리가 최소 거리에 위배되면 제거
                count += 1
            else:
                last_rock = rock
        
        if distance - last_rock < mid: # 마지막 바위와 끝 지점과의 거리
            count += 1
        
        if count > n: # n개보다 많이 제거해야 하면 왼쪽 선택
            right = mid - 1
        else: # n개 이하를 제거해서 달성할 수 있다면 오른쪽 선택
            answer = mid
            left = mid + 1
        
    return answer
