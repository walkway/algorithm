import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 * Furthest Building You Can Reach
 */
class Leetcode1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }

            int difference = heights[i + 1] - heights[i];
            bricks -= difference;
            priorityQueue.add(difference);

            if (bricks < 0) {
                bricks += priorityQueue.poll();
                if (ladders > 0) {
                    ladders--;
                } else return i;
            }
        }

        return heights.length - 1;
    }

}
