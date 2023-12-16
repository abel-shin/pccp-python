package day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/43164

/*
 * 문자열로 구성된 노드를 다뤄야 하는 백트래킹 DFS 문제입니다.
 * 문자열에 겁먹지 말고, 모든 티켓을 사용하는 방법을 전수조사 하면 됩니다.
 */


class Solution4 {
    List<String> list;
    boolean[] ticketUsed;
    String[][] tickets;

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        ticketUsed = new boolean[tickets.length];
        this.tickets = tickets;

        dfs(0, "ICN", "ICN");

        Collections.sort(list);
        return list.get(0).split(" ");
    }

    void dfs(int depth, String curr, String path){
        if (depth == tickets.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!ticketUsed[i] && curr.equals(tickets[i][0])) {
                ticketUsed[i] = true;
                dfs(depth+1, tickets[i][1], path + " " + tickets[i][1]);
                ticketUsed[i] = false;
            }
        }
    }
}