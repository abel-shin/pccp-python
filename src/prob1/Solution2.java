package prob1;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121684

/*
 * DFS를 이용한 정석적인 순열 문제입니다.
 * 순열을 완전 탐색하면서 가장 좋은 경우를 찾아내면 됩니다.
 */

class Solution2 {
    int answer = 0;
    int numStudent;
    int numCategory;
    int[][] ability;
    
    public int solution(int[][] ability) {    
        numStudent = ability.length;
        numCategory = ability[0].length;
        this.ability = ability;
        boolean[] status = new boolean[numStudent]; // 학생이 중복 참여할 수 없으므로, 중복을 방지하기 위한 상태 배열
        
        dfs(0, 0, status); // 능력총합0, 0번째 종목부터 시작
        
        return answer;
    }
    
    void dfs(int abilitySum, int j, boolean[] status) {
        if (j == numCategory) { // 모든 종목에 학생을 다 배정한 경우
            answer = Math.max(abilitySum, answer); // 정답을 업데이트하고 종료
            return;
        }
        
        for (int i = 0; i < numStudent; i++) {
            if (status[i] == true) { // 이미 다른 종목에 참가한 학생은 패스
                continue;
            }
            
            status[i] = true;
            dfs(abilitySum + ability[i][j], j+1, status); // 현재 학생을 현재 종목에 참가시키고 진행
            status[i] = false;
            
        }
        
    }
}