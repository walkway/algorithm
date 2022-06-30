import java.util.*;

/**
 *
 * Increasing Subsequences
 */
class Leetcode491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(0, nums, new ArrayList<>(), result);

        return new ArrayList<>(result);
    }

    public void backtrack(int start, int[] nums, List<Integer> elements, Set<List<Integer>> result) {
        if (elements.size() >= 2) {
            result.add(new ArrayList<>(elements));
        }

        for (int i = start; i < nums.length; i++) {
            if (elements.size() == 0 || elements.get(elements.size() - 1) <= nums[i]) {
                elements.add(nums[i]);
                backtrack(i + 1, nums, elements, result);
                elements.remove(elements.size() - 1);
            }
        }
    }

}