package easy.hashtable;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(4); // tail
        node.next.next.next.next = node.next;

        System.out.println(hasCycle(node));

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2); // tail
        node2.next.next = node2;

        System.out.println(hasCycle(node2));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode tail = head;
        Map<Integer, ListNode> map = new HashMap<>();

        while (tail.next != null) {
            if (map.containsKey(tail.val)) {
                return true;
            }

            map.put(tail.val, tail);
            tail = tail.next;
        }

        return false;
    }

    // O(1) solution:
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                return true;
            }
        }

        return false;
    }
}
