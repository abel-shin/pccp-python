package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165

/*
 * DFS를 이용한 완전 탐색 문제입니다.
 * 각 숫자를 더할지 뺄지 나누어나가는 이진트리라고 볼 수 있습니다.
 * 이진트리의 리프노드까지 탐색하여 원하는 타겟 숫자가 나오는지 확인합니다.
 */

class Solution1 {
    int[] numbers;
    int target;
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(-1, 0);
        return count;
    }
    
    void dfs(int i, int value) {
        if (i == numbers.length - 1) { // 리프 노드에 도달했을 때,
            if (value == target) {  // 타겟 숫자를 달성했으면 정답으로 카운트
                count++;
            }
            return;
        }
        
        dfs(i+1, value + numbers[i+1]); // 다음 숫자를 더하는 경우
        dfs(i+1, value - numbers[i+1]); // 다음 숫자를 빼는 경우
    }
}