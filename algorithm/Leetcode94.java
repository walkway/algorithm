import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Binary Tree Inorder Traversal
 */
class Leetcode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);

        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
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