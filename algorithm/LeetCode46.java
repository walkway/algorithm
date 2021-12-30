import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * Permutations
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] letters) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(), new boolean[letters.length], result, letters);

        return result;
    }

    private static void dfs(List<Integer> path, boolean[] used, List<List<Integer>> result, int[] letters) {
        if (path.size() == used.length) {
            result.add(new ArrayList<Integer>(path));

            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                continue;
            }

            path.add(letters[i]);
            used[i] = true;
            dfs(path, used, result, letters);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}