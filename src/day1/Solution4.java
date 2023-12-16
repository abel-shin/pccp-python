package day1;

// https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

/*
 * 장르별로 플레이 수를 구하기 위해 Map을 이용합니다.
 * 베스트 앨범에 수록하기 위한 순서대로 정렬하기 위해 Comparable을 구현합니다.
 * 장르별로 곡은 최대 2개씩만 수록할 수 있기 때문에, 이를 최종결과에 반영합니다.
 */

class Solution4 {
    Map<String, Integer> genreMap;
    
    public int[] solution(String[] genres, int[] plays) {
        genreMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) { // 장르별 플레이 수를 누적해 더합니다.
            if (!genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], 0);
            }
            genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
        }
        
        List<Item> items = IntStream.range(0, genres.length) // IntStream.range를 인덱스로 활용합니다.
                .boxed()
                .map(i -> new Item(genres[i], plays[i], i))
                .sorted() // Comparable을 이용해 적절히 정렬합니다.
                .collect(Collectors.toList());
        
        List<Integer> album = new ArrayList<>();
        
        String lastGenre = "";
        int count = 0;
        for (Item item: items) {
            if (lastGenre.equals(item.genre)) { // 같은 장르가 몇개 들어갔는지 확인
                count++;
            } else {
                count = 1;
            }
            lastGenre = item.genre;
            
            if (count > 2) { // 같은 장르가 이미 2개 들어갔다면 최종 앨범에 미포함
                continue;
            }
            
            album.add(item.index);
        }
        
        return album.stream().mapToInt(i->i).toArray();
    }
    
    class Item implements Comparable<Item> {
        String genre;
        int play;
        int index;
        
        public Item(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
        
        public int compareTo(Item o) {
            if (genre.equals(o.genre)) { // 장르가 같으면 플레이수로 정렬
                if (play == o.play) { // 플레이수가 같으면 원래 인덱스로 정렬
                    return index - o.index; // 인덱스로 정렬 (오름차순)
                }
                return o.play - play; // 플레이수로 정렬 (내림차순)
            }
            return genreMap.get(o.genre) - genreMap.get(genre); // 장르의 총 플레이수로 정렬 (내림차순)
        }
    }
}