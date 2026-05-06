package org.java.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class InformAllEmployees {

    public static void main(String[] args) {
        int n = 6;
        int headId = 2;
        int[] managers = {2, 2, -1, 2, 2, 2};
        int[] informTime = {0, 0, 1, 0, 0, 0};
        int ans = informAllEmployees(n, headId, managers, informTime);
        System.out.println(ans);
    }

    private static int informAllEmployees(int n, int headId, int[] managers, int[] informTime) {
        List<List<Integer>> adjList = getAdjList(n, headId, managers, informTime);
        return dfs(adjList, headId, informTime);
    }

    private static List<List<Integer>> getAdjList(int n, int headId, int[] managers, int[] informTime) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < managers.length; i++) {
            if (managers[i] == -1) continue;
            adjList.get(managers[i]).add(i);
        }
        System.out.println(adjList);
        return adjList;
    }

    private static int dfs(List<List<Integer>> adjList, int head, int[] informTime) {
        if (adjList.get(head).isEmpty()) return 0;
        int max = 0;
        for (int i = 0; i < adjList.get(head).size(); i++) {
            int currentHead = adjList.get(head).get(i);
            max = Math.max(max, informTime[head] + dfs(adjList, currentHead, informTime));
        }
        return max;
    }
}
