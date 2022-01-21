import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * Path Sum II
 */
class LeetCode113 {
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        search(new ArrayList<>(), root, targetSum, 0);

        return result;
    }

    private void search(List<Integer> path, TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        sum += node.val;
        if (node.left == null && node.right == null && targetSum == sum) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);

            return;
        }

        search(path, node.left, targetSum, sum);
        search(path, node.right, targetSum, sum);
        path.remove(path.size() - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}