import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * Course Schedule II
 */
class Leetcode210 {

    public static void main(String args[]) {
        System.out.println(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] course : prerequisites) {
            int prevCourse = course[1];
            int nextCourse = course[0];
            adjacency.get(prevCourse).add(nextCourse);
            indegree[nextCourse]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int resultIndex = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer currentCourse = queue.poll();
            result[resultIndex] = currentCourse;
            for (int course : adjacency.get(currentCourse)) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.offer(course);
                }
            }
            resultIndex++;
        }

        if (resultIndex != numCourses) {
            return new int[]{};
        }

        return result;
    }

}