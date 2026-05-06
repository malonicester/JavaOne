package org.java.graph;

import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int ans = openTheLock(deadends, target);
        System.out.println(ans);
    }

    private static int openTheLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<String>(Arrays.asList(deadends));
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>("0000", 0));
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String cur = pair.getKey();
            int curVal = pair.getValue();
            if (target.equals(cur)) return curVal;
            if (deadendSet.contains(cur)) continue;
            for (int i = 0; i < 4; i++) {
                char ch = cur.charAt(i);
                int right = moveRight(ch);
                int left = moveLeft(ch);

                String rightString = cur.substring(0, i) + right + cur.substring(i + 1);
                String leftString = cur.substring(0, i) + left + cur.substring(i + 1);

                if(!visited.contains(leftString)) {
                    visited.add(leftString);
                    queue.offer(new Pair<>(leftString, curVal + 1));
                }

                if(!visited.contains(rightString)) {
                    visited.add(rightString);
                    queue.offer(new Pair<>(rightString, curVal + 1));
                }
            }
        }
        return -1;
    }

    private static int moveRight(char ch) {
        int result = ch - '0';
        return (result + 1) % 10;
    }

    private static int moveLeft(char ch) {
        int result = ch - '0';
        result = (result - 1) % 10;
        return result < 0 ? 10 + result : result;
    }
}
