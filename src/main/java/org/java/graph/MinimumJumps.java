package org.java.graph;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] forbidden = {8, 3, 16, 6, 12, 20};
        int a = 15, b = 13, x = 11;
        int minimumJumpsToReachHome = minimumJumpsToReachHome(forbidden, a, b, x);
        System.out.println(minimumJumpsToReachHome);
    }

    private static int minimumJumpsToReachHome(int[] forbidden, int a, int b, int x) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> forbiddenSet = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        Queue<Pair<Integer, Pair<Long, Integer>>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, new Pair<>(0L, 0)));
        while (!queue.isEmpty()) {
            System.out.println(queue);
            Pair<Integer, Pair<Long, Integer>> pair = queue.poll();
            int stepCount = pair.getKey();
            long number = pair.getValue().getKey();
            int backCount = pair.getValue().getValue();
            if (number == x) return stepCount;
            if (number >= Integer.MAX_VALUE) return -1;
            if (forbiddenSet.contains((int)number) || number < 0 || backCount > 1) continue;

            long moveAheadWithA = number + a, moveBackWithB = number - b;

            if (!visited.contains(moveAheadWithA)) {
                visited.add((int)moveAheadWithA);
                queue.offer(new Pair<>(stepCount + 1, new Pair<>(moveAheadWithA, 0)));
            }

            if (!visited.contains(moveBackWithB)) {
                visited.add((int)moveBackWithB);
                queue.offer(new Pair<>(stepCount + 1, new Pair<>(moveBackWithB, backCount + 1)));
            }
        }
        return -1;
    }
}
