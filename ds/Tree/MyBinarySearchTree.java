package ds.Tree;

public class MyBinarySearchTree {
    int size;
    Node root;
    // QoL properties
    int minValue;
    int maxValue;

    public MyBinarySearchTree() {
        size = 0;
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
        root = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            root = newNode;
            size++;
            minValue = value;
            maxValue = value;
            return;
        }

        addNewValue(root, newNode);

        if (value > maxValue) {
            maxValue = value;
        } else if (value < minValue) {
            minValue = value;
        }

        size++;
    }

    private void addNewValue(Node root, Node newNode) {
        if (newNode.value < root.value) {
            if (root.left == null) {
                root.left = newNode;
                return;
            }

            addNewValue(root.left, newNode);
        } else {
            if (root.right == null) {
                root.right = newNode;
                return;
            }

            addNewValue(root.right, newNode);
        }
    }

    public boolean search(int value) {
        if (isEmpty()) {
            return false;
        }

        return search(root, value);
    }

    private boolean search(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        return search(root.left, value) || search(root.right, value);
    }

    public void delete(int value) {
        if (isEmpty() || !search(value)) {
            return;
        }

        root = deleteNode(root, value);
        size--;
    }

    private Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            // Node to delete found

            // Case 1: Node has no children or only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node has two children
            // Find the minimum value node in the right subtree
            root.value = minValue(root.right);

            // Delete the node that has the minimum value
            root.right = deleteNode(root.right, root.value);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Tree is empty.");
            return;
        }

        System.out.println("Displaying left tree:");
        displayNodeValue(root);
    }

    private void displayNodeValue(Node root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.value + " ");
        displayNodeValue(root.left);
        displayNodeValue(root.right);
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    // TODO:: implement preorder, inorder, postorder methods | dfs, bfs

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
