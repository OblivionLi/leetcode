package medium.linkedlist;

public class MaximumTwinSumOfALL {
    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));

        System.out.println(pairSum(head));
    }

    public static int pairSum(ListNode head) {
        ListNode current = head;

        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        current = head;
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = current.val;
            current = current.next;
        }

        int maxSum = 0;
        for (int i = 0; i < length / 2; i++) {
            int twinSum = values[i] + values[length - 1 - i];
            maxSum = Math.max(maxSum, twinSum);
        }

        return maxSum;
    }
}
