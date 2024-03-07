package ds;

import ds.LinkedList.MyDoublyLL;
import ds.LinkedList.MySinglyLL;

public class Starter {
    public static void main(String[] args) {
//        System.out.println("------Initializing Singly Linked list..\n");
//        initializeSinglyLL();
//        System.out.println("\n------Finished initializing Singly Linked list..");

        System.out.println("------Initializing Doubly Linked list..\n");
        initializeDoublyLL();
        System.out.println("\n------Finished initializing Doubly Linked list..");
    }

    private static void initializeDoublyLL() {
        MyDoublyLL list = new MyDoublyLL();

        int[] nums = {10, 5, 3, 2, 15, 7};
        System.out.println("Populating linked list..");
        for (int num : nums) {
            System.out.printf("Added num %d to the list (insertAtHead)\n", num);
            list.insertAtHead(num);
        }

        System.out.println(list);

        int[] nums2 = {1, 8, 4};
        System.out.println("Populating linked list..");
        for (int num : nums2) {
            System.out.printf("Added num %d to the list (insertAtTail)\n", num);
            list.insertAtTail(num);
        }

        System.out.println(list);

        System.out.println("\nInsert after Node(10), value (99):");
        list.insertAfter(new MyDoublyLL.Node(10), 99);

        System.out.println(list);

        System.out.println("\nInsert before Node(10), value (88):");
        list.insertBefore(new MyDoublyLL.Node(10), 88);

        System.out.println(list);

        System.out.println("\nInsert at index 3, value (100):");
        list.insertAtIndex(3, 100);

        System.out.println(list);

        System.out.println("\nGet node value at index 3: " + list.getAtIndex(3));

        System.out.println("\nDelete head");
        list.deleteHead();

        System.out.println(list);

        System.out.println("\nDelete tail");
        list.deleteTail();

        System.out.println(list);

        System.out.println("\nDelete Node(100)");
        list.deleteNode(list.searchForward(100));

        System.out.println(list);

        System.out.println("Reversing list: ");
        list.reverse();

        System.out.println(list);

        System.out.println("Split list from index 3: ");
        list.split(3);

        System.out.println(list);

        MyDoublyLL list2 = new MyDoublyLL();

        int[] nums3 = {9999, 8888, 1111};
        System.out.println("Populating linked list 2..");
        for (int num : nums3) {
            System.out.printf("Added num %d to the list 2 (insertAtHead)\n", num);
            list2.insertAtHead(num);
        }

        list.merge(list2);

        System.out.println(list);

        System.out.println("Clearing list");
        list.clear();

        System.out.println(list);
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



        System.out.println("Traversing the list");
        singlyLL.traverse();
        System.out.println("Checking list size: " + singlyLL.size());

        System.out.println("Splitting the list");
        singlyLL.split(5);

        System.out.println("Traversing the list");
        singlyLL.traverse();
        System.out.println("Checking list size: " + singlyLL.size());

        MySinglyLL newList = new MySinglyLL();

        int[] nums2 = {10, 5, 3};
        System.out.println("Populating linked list..");
        for (int num : nums2) {
            System.out.printf("Added num %d to the list\n", num);
            newList.insertAtHead(num);
        }

        singlyLL.merge(newList);

        System.out.println("Traversing the list");
        singlyLL.traverse();
        System.out.println("Checking list size: " + singlyLL.size());

        System.out.println("\nClearing the list..");
        singlyLL.clear();
    }
}
