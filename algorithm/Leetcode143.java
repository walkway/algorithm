import java.util.*;

/**
 * https://leetcode.com/problems/reorder-list/
 * Reorder List
 */
class Leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Stack<ListNode> nodes = new Stack<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }

        int count = nodes.size() / 2;
        node = head;
        while (count > 0) {
            ListNode last = nodes.pop();
            ListNode temp = node.next;
            node.next = last;
            last.next = temp;
            node = temp;
            count--;
        }

        nodes.pop().next = null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}