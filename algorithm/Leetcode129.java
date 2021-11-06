/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Sum Root to Leaf Numbers
 */
class Leetcode129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }

        search(root, String.valueOf(root.val));

        return sum;
    }

    private void search(TreeNode node, String value) {
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(value);

            return;
        }

        if (node.left != null) {
            search(node.left, value + node.left.val);
        }

        if (node.right != null) {
            search(node.right, value + node.right.val);
        }
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