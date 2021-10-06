/**
 * https://leetcode.com/problems/sort-list/discuss/1435328/Simple-JAVA-Solution
 * Sort List
 */
class Leetcode148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid.next = null;
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);
        return merge(left_side, right_side);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode fin = result;

        while (left != null && right != null) {
            if (left.val > right.val) {
                result.next = right;
                right = right.next;
            } else {
                result.next = left;
                left = left.next;
            }
            result = result.next;
        }
        while (left != null) {
            result.next = left;
            left = left.next;
            result = result.next;
        }
        while (right != null) {
            result.next = right;
            right = right.next;
            result = result.next;
        }
        return fin.next;
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