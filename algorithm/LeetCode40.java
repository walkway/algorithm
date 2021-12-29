import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * Combination Sum II
 */
public class LeetCode40 {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void backtrack(List<Integer> combination, int[] candidate, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(combination));
        } else {
            for (int i = start; i < candidate.length; i++) {
                if (i > start && candidate[i] == candidate[i - 1]) {
                    continue;
                }
                combination.add(candidate[i]);
                backtrack(combination, candidate, remain - candidate[i], i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
