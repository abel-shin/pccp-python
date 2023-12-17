# https://school.programmers.co.kr/learn/courses/30/lessons/42579


# 장르별로 플레이 수를 구하기 위해 Map을 이용합니다.
# 베스트 앨범에 수록하기 위한 순서대로 정렬하기 위해 리스트를 만듭니다.
# 장르별로 곡은 최대 2개씩만 수록할 수 있기 때문에, 이를 최종결과에 반영합니다.

def solution(genres, plays):
    genre_map = dict()
    
    for i in range(len(genres)): # // 장르별 플레이 수를 누적해 더합니다.
        if genres[i] not in genre_map:
            genre_map[genres[i]] = 0
        genre_map[genres[i]] += plays[i]
    
    items = [(-genre_map[genres[i]], -plays[i], i) 
             for i in range(len(genres))]
    items.sort() # 장르 플레이 수(내림차순), 플레이 수(내림차순), 인덱스(오름차순)

    album = []
    
    last_genre = ''
    count = 0
    for item in items:
        if last_genre == genres[item[2]]: # 같은 장르가 몇개 들어갔는지 확인
            count += 1
        else:
            count = 1
        last_genre = genres[item[2]]
        
        if count > 2: # 같은 장르가 이미 2개 들어갔다면 최종 앨범에 미포함
            continue
        
        album.append(item[2])
    
    return album
