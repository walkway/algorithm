import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * Subsets II
 */
class Leetcode90 {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1,2,2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);

        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> element = result.get(i);
                List<Integer> temp = new ArrayList<>(element);
                temp.add(n);

                if (!result.contains(temp)) {
                    result.add(temp);
                }
            }
        }

        return result;
    }
}
