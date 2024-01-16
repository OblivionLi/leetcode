package easy.linkedlist;

import java.util.ArrayList;
import java.util.List;


public class MergeTwoSortedLists {
    static class ListNode {
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
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        list1.val = 1;
        ListNode list1Second = new ListNode(2);
        list1.next = list1Second;
        list1Second.next = new ListNode(4);

        ListNode list2 = new ListNode();
        list2.val = 1;
        ListNode list2Second = new ListNode(3);
        list2.next = list2Second;
        list2Second.next = new ListNode(4);

        System.out.println(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummyHead.next;
    }
}
