import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * Combination Sum III
 */
class Leetcode216 {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(new ArrayList<>(), k, n, 1, 0);

        return result;
    }

    private void backtrack(List<Integer> combination, int k, int n, int start, int sum) {
        if (combination.size() == k && sum == n) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= 9; i++) {
            combination.add(i);
            backtrack(combination, k, n, i + 1, sum + i);
            combination.remove(combination.size() - 1);
        }
    }

}