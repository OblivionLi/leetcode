package patterns.fastslowpointers.easy;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;

        Stack<ListNode> stack = new Stack<>();
        while (fast != null) {
            stack.add(fast);
            fast = fast.next;
        }

        ListNode slow = head;
        while (!stack.isEmpty()) {
            if (slow.val != stack.pop().val) {
                return false;
            }

            slow = slow.next;
        }

        return true;
    }

    // second solution with O(1) space complexity
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null)
//            return true;
//
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        ListNode secondHalf = reverse(slow.next);
//        ListNode firstHalf = head;
//
//        while (secondHalf != null) {
//            if (firstHalf.val != secondHalf.val)
//                return false;
//            firstHalf = firstHalf.next;
//            secondHalf = secondHalf.next;
//        }
//        return true;
//    }
//
//    private static ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        ListNode current = head;
//        while (current != null) {
//            ListNode next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//        return prev;
//    }
}

class ListNode {
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
