package ds;

import ds.LinkedList.MySinglyLL;

public class Starter {
    public static void main(String[] args) {
        System.out.println("------Initializing Singly Linked list..\n");
        initializeSinglyLL();
        System.out.println("\n------Finished initializing Singly Linked list..");
    }

    private static void initializeSinglyLL() {
        MySinglyLL singlyLL = new MySinglyLL();

        int[] nums = {10, 5, 3, 2, 15, 7};
        System.out.println("Populating linked list..");
        for (int num : nums) {
            System.out.printf("Added num %d to the list\n", num);
            singlyLL.insertAtHead(num);
        }

        System.out.println("\nTraversing the list");
        singlyLL.traverse();

        System.out.println("\nGetting value from list at index 3: " + singlyLL.getAtIndex(3));
        System.out.println("\nChecking list size: " + singlyLL.size());
        System.out.println("\nIs list empty: " + singlyLL.isEmpty());

        System.out.println("\nReversing list");
        singlyLL.reverse();

        System.out.println("\nTraversing the list");
        singlyLL.traverse();

        System.out.println("\nSearching by value: 2: \n" + singlyLL.search(2));

        System.out.println("\nCheck if list contains value of 2\n" + singlyLL.contains(2)); // should return true
        System.out.println("\nCheck if list contains value of 22\n" + singlyLL.contains(22)); // should return false

        System.out.println("\nTraversing the list");
        singlyLL.traverse();

        System.out.println("\nAdding value 99 at the tail:");
        singlyLL.insertAtTail(99);
        singlyLL.traverse();


        System.out.println("\nInsert value 66 after Node with the value (3):");
        singlyLL.insertAfter(singlyLL.search(3), 66);

        System.out.println("\nTraversing the list");
        singlyLL.traverse();

        System.out.println("\nInsert value 99 before Node with the value (3):");
        singlyLL.insertBefore(singlyLL.search(3), 99);

        System.out.println("\nTraversing the list");
        singlyLL.traverse();

        System.out.println("\nInsert value 76 at index 5:");
        singlyLL.insertAtIndex(5, 76);

        System.out.println("\nTraversing the list");
        singlyLL.traverse();
        System.out.println("Checking list size: " + singlyLL.size());

        System.out.println("\nGet head value: " + singlyLL.getHead());
        System.out.println("\nGet tail value: " + singlyLL.getTail());

        System.out.println("\nClearing the list..");
        singlyLL.clear();

        System.out.println("Traversing the list");
        singlyLL.traverse();
        System.out.println("Checking list size: " + singlyLL.size());
    }
}
