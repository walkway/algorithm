import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * Combinations
 */
class Leetcode77 {
    private final List<List<Integer>> result = new ArrayList<>();
    private int number;

    public List<List<Integer>> combine(int n, int k) {
        number = n;
        combination(new ArrayList<>(), 1, k);

        return result;
    }

    private void combination(List<Integer> combination, int start, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));

            return;
        }

        for (int i = start; i <= number; i++) {
            combination.add(i);
            combination(combination, i + 1, k - 1);
            combination.remove(combination.size() - 1);
        }
    }
}