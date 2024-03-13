package ds.Tree;

public class MyAVLTree {
    Node root;

    public MyAVLTree() {
        root = null;
    }

    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }

        insertNode(root, node);
        rebalance(node);
    }

    private void rebalance(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1) {
            // Left Left Case
            if (getBalance(node.left) >= 0) {
                rightRotate(node);
            }
            // Left Right Case
            else {
                node.left = leftRotate(node.left);
                rightRotate(node);
            }
        } else if (balance < -1) {
            // Right Right Case
            if (getBalance(node.right) <= 0) {
                leftRotate(node);
            }
            // Right Left Case
            else {
                node.right = rightRotate(node.right);
                leftRotate(node);
            }
        }
    }

    private void insertNode(Node root, Node newNode) {
        if (newNode.key > root.key) {
            if (root.right == null) {
                root.right = newNode;
            } else {
                insertNode(root.right, newNode);
            }
        } else {
            if (root.left == null) {
                root.left = newNode;
            } else {
                insertNode(root.left, newNode);
            }
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public void traverseOrder(String order) {
        switch (order) {
            case "preorder" -> traversePreOrder(root);
            case "inorder" -> traverseInOrder(root);
            case "postorder" -> traversePostOrder(root);
        }
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.left);
        System.out.print(root.key + " ");
        traverseInOrder(root.right);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }

        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.key + " ");
    }

    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.key + " ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public void delete(int key) {
        if (!contains(key)) {
            return;
        }

        root = deleteNode(root, key);
        rebalance(root);
    }

    private Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete found
            // nodes with one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                // No child case
                if (temp == null) {
                    root = null;
                } else { // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                // Node with two children: get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null) {
            return root;
        }

        // Step 2: update height of the current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Step 3: get the balance factor
        int balance = getBalance(root);

        // Step 4: if the node is unbalanced, then try out the 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node minValueNode(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public boolean contains(int key) {
        return contains(key, root);
    }

    private boolean contains(int key, Node node) {
        if (node == null) {
            return false;
        }

        if (node.key == key) {
            return true;
        }

        if (node.key > key) {
            return contains(key, node.left);
        }

        return contains(key, node.right);
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        // Return new root
        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Return new root
        return y;
    }

    public void clear() {
        root = null;
    }

    static class Node {
        int key, height;
        Node left, right;

        public Node(int key) {
            this.key = key;
            height = 1;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", height=" + height +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
