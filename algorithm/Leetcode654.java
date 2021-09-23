/**
 * https://leetcode.com/problems/maximum-binary-tree/
 * Maximum Binary Tree
 */
class Leetcode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return built(nums, 0, nums.length - 1);
    }

    private TreeNode built(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
        }

        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = built(nums, start, maxIndex - 1);
        node.right = built(nums, maxIndex + 1, end);

        return node;
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