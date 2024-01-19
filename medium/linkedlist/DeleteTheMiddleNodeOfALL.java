package medium.linkedlist;

import org.w3c.dom.NodeList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "node:" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class DeleteTheMiddleNodeOfALL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));

        System.out.println(deleteMiddle(head));

        ListNode head2 = new ListNode(2, new ListNode(1));

        System.out.println(deleteMiddle(head2));

        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        System.out.println(deleteMiddle(head3));
    }

    public static ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = slow.next;
            slow.next = null;
        } else {
            head = head.next;
        }

        return head;
    }
}
