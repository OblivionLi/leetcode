package ds.Tree;

public class MyRedBlackTree {
    public Node root, NIL;

    public MyRedBlackTree() {
        root = null;
        NIL = null;
    }

    public void preOrderHelper(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderHelper(node.left);
        preOrderHelper(node.right);
    }

    public void inOrderHelper(Node node) {
        if (node == null) {
            return;
        }

        inOrderHelper(node.left);
        System.out.print(node.data + " ");
        inOrderHelper(node.right);
    }

    public void postOrderHelper(Node node) {
        if (node == null) {
            return;
        }

        postOrderHelper(node.left);
        postOrderHelper(node.right);
        System.out.print(node.data + " ");
    }

    public Node searchTreeHelper(Node node, int key) {
        if (node == null || key == node.data) {
            return node;
        }

        if (key < node.data) {
            return searchTreeHelper(node.left, key);
        } else {
            return searchTreeHelper(node.right, key);
        }
    }

    public void insert(int key) {
        Node node = new Node(key, 1);

        if (root == null) {
            root = node;
            node.color = 0;
            node.parent = null;
            return;
        }

        insertHelper(root, node);
        fixInsert(node);
    }

    private void insertHelper(Node node, Node newNode) {
        if (node == null) {
            return;
        }

        newNode.parent = node;

        if (newNode.data > node.data) {
            if (node.right == null) {
                node.right = newNode;
                return;
            }
            insertHelper(node.right, newNode);
        } else {
            if (node.left == null) {
                node.left = newNode;
                return;
            }
            insertHelper(node.left, newNode);
        }
    }

    public void fixInsert(Node k) {
        Node u;

        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;  // uncle
                if (u != null && u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rotateRight(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rotateLeft(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // uncle

                if (u != null && u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        rotateLeft(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rotateRight(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }

        root.color = 0;
    }

    public void deleteNode(int data) {
        Node node = searchTreeHelper(root, data);
        if (root == null) {
            return;
        }

        Node x, y;
        y = node;
        int yOriginalColor = y.color;

        if (node.left == null) {
            x = node.right;
            replaceNode(node, node.right);
        } else if (node.right == null) {
            x = node.left;
            replaceNode(node, node.left);
        } else {
            y = minimum(node.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == node) {
                if (x != null) {
                    x.parent = y;
                }
            } else {
                replaceNode(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }
            replaceNode(node, y);
            y.left = node.left;
            y.left.parent = y;
            y.color = node.color;
        }

        if (yOriginalColor == 0 && x != null) {
            fixDelete(x);
        }
    }

    public Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void replaceNode(Node oldNode, Node newNode) {
        if (oldNode.parent == null) {
            root = newNode;
        } else if (oldNode == oldNode.parent.left) {
            oldNode.parent.left = newNode;
        } else {
            oldNode.parent.right = newNode;
        }
        if (newNode != null) {
            newNode.parent = oldNode.parent;
        }
    }

    public void fixDelete(Node x) {
        Node s;
        while (x != root && x != null && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    rotateLeft(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        s.left.color = 0;
                        s.color = 1;
                        rotateRight(s);
                        s = x.parent.right;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    rotateRight(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        s.right.color = 0;
                        s.color = 1;
                        rotateLeft(s);
                        s = x.parent.left;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }

    private void rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        if (node.right != null) {
            node.right.parent = node;
        }

        temp.parent = node.parent;
        if (node.parent == null) {
            root = temp;
        } else if (node == node.parent.left) {
            node.parent.left = temp;
        } else {
            node.parent.right = temp;
        }

        temp.left = node;
        node.parent = temp;
    }

    private void rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        if (node.left != null) {
            node.left.parent = node;
        }

        temp.parent = node.parent;
        if (node.parent == null) {
            root = temp;
        } else if (node == node.parent.right) {
            node.parent.right = temp;
        } else {
            node.parent.left = temp;
        }

        temp.right = node;
        node.parent = temp;
    }

    public void prettyPrint() {
        inOrderHelper(root);
        System.out.println();
    }

    public static class Node {
        // color = 1 => red; color = 0 => black
        public int data, color;
        Node left, right, parent;

        public Node(int data, int color) {
            this.data = data;
            this.color = color;
            left = null;
            right = null;
            parent = null;
        }
    }
}
