package ds;

import ds.ArrayList.MyArrayList;
import ds.LinkedList.MyDoublyLL;
import ds.LinkedList.MySinglyLL;
import ds.MyHT.MyHT;
import ds.Queue.MyQueue;
import ds.Stack.MyStack;
import ds.Tree.MyAVLTree;
import ds.Tree.MyBinarySearchTree;
import ds.Tree.MyRedBlackTree;
import ds.Tree.MyTrie;

import java.util.Arrays;

public class Starter {
    public static void main(String[] args) {
//        System.out.println("------Initializing Singly Linked list..\n");
//        initializeSinglyLL();
//        System.out.println("\n------Finished initializing Singly Linked list..");

//        System.out.println("------Initializing Doubly Linked list..\n");
//        initializeDoublyLL();
//        System.out.println("\n------Finished initializing Doubly Linked list..");

//        System.out.println("------Initializing Stack..\n");
//        initializeStack();
//        System.out.println("\n------Finished initializing Stack..");

//        System.out.println("------Initializing Queue..\n");
//        initializeQueue();
//        System.out.println("\n------Finished initializing Queue..");

//        System.out.println("------Initializing ArrayList..\n");
//        initializeArrayList();
//        System.out.println("\n------Finished initializing ArrayList..");
        
//        System.out.println("------Initializing HashTable..\n");
//        initializeHashTable();
//        System.out.println("\n------Finished initializing HashTable..");

//        System.out.println("------Initializing BST..\n");
//        initializeBST();
//        System.out.println("\n------Finished initializing BST..");

//        System.out.println("------Initializing AVLTree..\n");
//        initializeAVLTree();
//        System.out.println("\n------Finished initializing AVLTree..");

//        System.out.println("------Initializing Trie..\n");
//        initializeTrie();
//        System.out.println("\n------Finished initializing Trie..");

//        System.out.println("------Initializing Trie..\n");
//        initializeTrie();
//        System.out.println("\n------Finished initializing Trie..");

        System.out.println("------Initializing RedBlackTree..\n");
        initializeRedBlackTree();
        System.out.println("\n------Finished initializing RedBlackTree..");
    }

    private static void initializeRedBlackTree() {
        MyRedBlackTree rbt = new MyRedBlackTree();

        rbt.insert(1);
        rbt.insert(2);
        rbt.insert(3);
        rbt.insert(4);
        rbt.insert(5);
        rbt.insert(6);
        rbt.insert(7);

        // Print the tree
        rbt.prettyPrint();

        // Search for a value
        MyRedBlackTree.Node node = rbt.searchTreeHelper(rbt.root, 3);
        System.out.println("\nSearched node: " + node.data);

        // Delete a value
        System.out.println("Deleting node with value 2");
        rbt.deleteNode(2);

        // Print the tree after deletion
        rbt.prettyPrint();
    }

    private static void initializeTrie() {
        MyTrie trie = new MyTrie();

        System.out.printf("Inserting the following values: %s, %s, %s, %s, %s, %s, %s\n", "apple", "app", "banana", "band", "dog", "dove", "duck");

        // Test insert
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");
        trie.insert("band");
        trie.insert("dog");
        trie.insert("dove");
        trie.insert("duck");

        // Test search
        System.out.printf("Searching words: %s, %s, %s, %s, %s, %s\n", "apple", "app", "ban", "band", "do", "dove");
        System.out.println(trie.search("apple"));  // should return true
        System.out.println(trie.search("app"));    // should return true
        System.out.println(trie.search("ban"));    // should return false
        System.out.println(trie.search("band"));   // should return true
        System.out.println(trie.search("do"));     // should return false
        System.out.println(trie.search("dove"));   // should return true

        // Print all words
        System.out.println("\nAll current trie words:");
        trie.printAllWords();

        // Test startsWith
        System.out.printf("\n\nCheck if words starts with: %s, %s, %s, %s:\n", "a", "ban", "d", "z");
        System.out.println(trie.startsWith("a"));  // should return true
        System.out.println(trie.startsWith("ban")); // should return true
        System.out.println(trie.startsWith("d"));  // should return true
        System.out.println(trie.startsWith("z"));  // should return false

        // Test delete
        System.out.printf("\nDeleting word %s", "apple");
        trie.delete("apple");

        System.out.printf("\n\nSearching for word %s\n", "apple");
        System.out.println(trie.search("apple"));  // should return false
    }

    private static void initializeAVLTree() {
        MyAVLTree avl = new MyAVLTree();
        avl.insert(20);
        avl.insert(10);
        avl.insert(35);
        avl.insert(5);
        avl.insert(15);
        avl.insert(30);
        avl.insert(40);
        avl.insert(25);

        System.out.println("\nTraverse preorder");
        avl.traverseOrder("preorder");

        System.out.println("\n\nCheck if contains 35: " + avl.contains(35));

        System.out.println("\nDelete key: 35");
        avl.delete(35);

        System.out.println("\nTraverse preorder");
        avl.traverseOrder("preorder");
    }

    private static void initializeBST() {
        MyBinarySearchTree bst = new MyBinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(15);
        bst.insert(12);
        bst.insert(18);

        bst.display();

        System.out.println("\nGet min value of tree: " + bst.getMinValue());
        System.out.println("Get max value of tree: " + bst.getMaxValue());
        System.out.println("\nDoes Node(3) exist in tree? " + bst.search(3));
        System.out.println("\nDoes Node(100) exist in tree? " + bst.search(100));
        System.out.println("\nDeleted Node(5)");
        bst.delete(5);

        bst.display();

        System.out.println("\n\nTraverse preorder");
        bst.traverseOrder("preorder");

        System.out.println("\n\nTraverse postorder");
        bst.traverseOrder("postorder");

        System.out.println("\n\nTraverse inorder");
        bst.traverseOrder("inorder");

        System.out.println("\n\nTraverse BFS");
        bst.traverseOrder("bfs");
    }

    private static void initializeHashTable() {
        MyHT<Integer, Integer> myHT = new MyHT<Integer, Integer>(10);

        System.out.println("\nAdding keys and values: ");
        myHT.put(3, 333);
        myHT.put(1, 111);
        myHT.put(2, 222);
        myHT.put(1, 1111);

        System.out.println("\nGet index 1 values: " + myHT.get(1));
        System.out.println("Get index 2 values: " + myHT.get(2));
        System.out.println("Remove index 1 value: " + myHT.remove(1));
        System.out.println("Get index 1 values: " + myHT.get(1));
        System.out.println("\nContains key 2? "+ myHT.containsKey(2));
        System.out.println("Contains key 9? "+ myHT.containsKey(9));
        System.out.println("\nContains value 222? " + myHT.containsValue(222));
        System.out.println("Contains value 9999? " + myHT.containsValue(9999));

        System.out.println("\nGet all distinct keys: " + myHT.keys());
        System.out.println("Get all values: " + myHT.values());

        System.out.println("\nCheck size: " + myHT.size());
        System.out.println("Check if empty: " + myHT.isEmpty());

        System.out.println("\nDisplay table: " + myHT.displayHT());
        System.out.println("\nClear table: ");
        myHT.clear();
        System.out.println("\nDisplay table: " + myHT.displayHT());
    }

    private static void initializeArrayList() {
        MyArrayList arr = new MyArrayList();

        System.out.println("Adding values {2, 5, 6, 1, 0, 10}");
        int[] values = {2, 5, 6, 1, 0, 10};
        for (int num : values) {
            arr.add(num);
        }

        System.out.println(arr);

        arr.set(5, 999);

        System.out.println(arr);

        System.out.println("\nGet value at index 2: " + arr.get(5));

        System.out.println("\nAdd new value 777 at index 2");
        arr.add(2, 777);
        System.out.println(arr);

        System.out.println("Add new value 666 at index 5");
        arr.add(5, 666);
        System.out.println(arr);

        System.out.println("Add new value 333 at index 1");
        arr.add(1, 333);
        System.out.println(arr);

        System.out.println("\nRemoved element at index 1: " + arr.remove(1));
        System.out.println(arr);

        System.out.println("\nContains element 666? " + arr.contains(666));
        System.out.println("\nContains element 123? " + arr.contains(123));
        System.out.println("\nIndex of 6: " + arr.indexOf(6));

        System.out.println("\nAdd new value 5");
        arr.add(5);

        System.out.println(arr);

        System.out.println("\nCheck last occurred element 5 index: " + arr.lastIndexOf(5));

        System.out.println("\nTo array: " + Arrays.toString(arr.toArray()));

        int[] newList = {6, 4, 21, 11};
        arr.addAll(newList);
        System.out.println(Arrays.toString(arr.toArray()));

        System.out.println("\nReverse array: " + Arrays.toString(arr.reverseArray()));

        System.out.println("\nTo array: " + Arrays.toString(arr.toArray()));
        System.out.println("\nSort array: " + Arrays.toString(arr.sortArray()));
        System.out.println("\nIndex of element 6 (binary search) searched: " + arr.binarySearch(arr.sortArray(), 6));
        System.out.println("Index of element 2 (binary search) searched: " + arr.binarySearch(arr.sortArray(), 2));
        System.out.println("Index of element 777 (binary search) searched: " + arr.binarySearch(arr.sortArray(), 777));
        System.out.println("Index of element 12345 (binary search) searched: " + arr.binarySearch(arr.sortArray(), 12345));
    }

    private static void initializeQueue() {
        MyQueue queue = new MyQueue();

        int[] nums = {10, 5, 3, 2, 15, 7};
        System.out.println("Populating queue..");
        for (int num : nums) {
            System.out.printf("Added num %d to the queue\n", num);
            queue.enqueue(num);
        }

        System.out.println("\nConvert queue to array: " + Arrays.toString(queue.toArray()));

        System.out.println("\nDequeued Node: " + queue.dequeue());

        System.out.println("\nConvert queue to array: " + Arrays.toString(queue.toArray()));

        System.out.println("\nPeek Node: " + queue.peek());

        System.out.println("\nDoes queue contain value 2? " + queue.contains(2));

        System.out.println("\nDoes queue contain value 99? " + queue.contains(99));

        int[] nums2 = {99, 111, 222};
        System.out.println("\nPopulating queue with a list of values..");
        queue.addAll(nums2);

        System.out.println("\nConvert queue to array: " + Arrays.toString(queue.toArray()));

        System.out.println("\nRemoved Node(2) from queue: " + queue.remove(2));

        System.out.println("\nConvert queue to array: " + Arrays.toString(queue.toArray()));
        System.out.println("\nCheck new tail: " + queue.checkTail());
    }

    private static void initializeStack() {
        MyStack stack = new MyStack();

        int[] nums = {10, 5, 3, 2, 15, 7};
        System.out.println("Populating stack..");
        for (int num : nums) {
            System.out.printf("Added num %d to the stack\n", num);
            stack.push(num);
        }

        System.out.println("\nPopping node: " + stack.pop());
        System.out.println("\nPeek node: " + stack.peek());
        System.out.println("\nSearching node(2) index: " + stack.search(new MyStack.Node(3)));

        System.out.println("\nConvert stack to array: " + Arrays.toString(stack.toArray()));

        int[] arr = {9, 8, 7};
        System.out.println("\nPush new list to stack {9, 8, 7}:");
        stack.pushAll(arr);
        System.out.println("\nConvert stack to array: " + Arrays.toString(stack.toArray()));

        System.out.println("\nPop until Node(15):");
        stack.popUntil(new MyStack.Node(8));
        System.out.println("\nConvert stack to array: " + Arrays.toString(stack.toArray()));

        System.out.println("\nPush if absent 999:");
        stack.pushIfAbsent(999);

        System.out.println("\nConvert stack to array: " + Arrays.toString(stack.toArray()));

        System.out.println("\nReverse stack");
        stack.reverse();

        System.out.println("\nConvert stack to array: " + Arrays.toString(stack.toArray()));
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
