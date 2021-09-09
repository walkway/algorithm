import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Binary Tree Right Side View
 */
class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideNodes = new ArrayList<>();
        if (root == null) {
            return rightSideNodes;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = nodes.poll();
                if (i == size - 1) {
                    rightSideNodes.add(current.val);
                }

                if (current.left != null) {
                    nodes.offer(current.left);
                }

                if (current.right != null) {
                    nodes.offer(current.right);
                }
            }
        }

        return rightSideNodes;
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