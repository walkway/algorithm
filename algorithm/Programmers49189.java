import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 * 가장 먼 노드
 */
class Programmers49189 {
    public static void main(String args[]) {
        int result = solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println(result);
    }

    public static int solution(int n, int[][] edge) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        int[] distance = new int[n + 1];

        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]][edge[i][1]] = true;
            graph[edge[i][1]][edge[i][0]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int i = 2; i <= n; i++) {
                if (distance[i] == 0 && graph[node][i]) {
                    queue.offer(i);
                    distance[i] = distance[node] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] > max)
                max = distance[i];
        }

        int count = 0;
        for (int i : distance) {
            if (max == i)
                count++;
        }
        return count;
    }
}