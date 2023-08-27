import java.util.LinkedList;
import java.util.Queue;

class TreeSolution {

    public static void main(String[] args) {
        Tree root = newTree(6);

        int sum = sum(root);
        System.out.println(sum);
    }

    public static Tree newTree(int x) {
        Tree node = new Tree();
        node.x = x;
        node.l = node.r = null;

        return (node);
    }

    public static int sum(Tree root) {
        int sum = 0;

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree temp = queue.poll();
            sum += temp.x;

            if (temp.l != null) {
                queue.add(temp.l);
            }
            if (temp.r != null) {
                queue.add(temp.r);
            }
        }

        return sum;
    }

    public static class Tree {
        int x;
        Tree l;
        Tree r;
    }

}
