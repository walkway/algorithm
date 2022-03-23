import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets
 * Subsets
 */
class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, int index) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, result, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
