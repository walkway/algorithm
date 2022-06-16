import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86971
 * 전력망을 둘로 나누기
 */
class Programmers86971 {

    public int solution(int n, int[][] wires) {
        List<Integer>[] nodes = new ArrayList[n + 1];
        boolean[] visit = new boolean[n + 1];
        int[] subNodes = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            nodes[wire[0]].add(wire[1]);
            nodes[wire[1]].add(wire[0]);
        }

        dfs(1, 0, nodes, subNodes, visit);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            subNodes[i]++;
            int difference = Math.abs(n - subNodes[i] - subNodes[i]);
            min = Math.min(min, difference);
        }

        return min;
    }

    public void dfs(int index, int parent, List<Integer>[] nodes, int[] subNodes, boolean[] visit) {
        visit[index] = true;
        for (Integer next : nodes[index]) {
            if (visit[next]) {
                continue;
            }

            dfs(next, index, nodes, subNodes, visit);
            subNodes[index]++;
        }

        subNodes[parent] += subNodes[index];
    }

}