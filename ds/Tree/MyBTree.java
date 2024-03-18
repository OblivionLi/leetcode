package ds.Tree;

public class MyBTree<Key extends Comparable<Key>, Value> {
    static int MAX_CHILDREN = 4; // per node
    Node root;
    int height;
    int KVPairs; // key-value pairs

    public MyBTree() {
        root = new Node(0);
    }

    public Value get(Key key) {
        if (key == null) {
            return null; // or throw exception
        }

        return search(root, key, height);
    }

    private Value search(Node node, Key key, int height) {
        Entry[] children = node.children;

        if (height == 0) {
            for (int i = 0; i < node.childrenCount; i++) {
                if (key.equals(children[i].key)) {
                    return (Value) children[i].val;
                }
            }
        } else {
            for (int j = 0; j < node.childrenCount; j++) {
                if (j + 1 == node.childrenCount || less(key, children[j + 1].key)) {
                    return search(children[j].next, key, height - 1);
                }
            }
        }

        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) {
            return;
        }

        Node u = insert(root, key, val, height);
        KVPairs++;

        if (u == null) {
            return;
        }

        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, root);

        root = t;
        height++;
    }

    private Node insert(Node node, Key key, Value val, int height) {
        int i;
        Entry t = new Entry(key, val, null);

        if (height == 0) {
            for (i = 0; i < node.childrenCount; i++) {
                if (less(key, node.children[i].key)) {
                    break;
                }
            }
        } else {
            for (i = 0; i < node.childrenCount; i++) {
                if ((i + 1 == node.childrenCount) || less(key, node.children[i + 1].key)) {
                    Node u = insert(node.children[i++].next, key, val, height - 1);

                    if (u == null) {
                        return null;
                    }

                    t.key = u.children[0].key;
                    t.val = null;
                    t.next = u;
                    break;
                }
            }
        }

        for (int j = node.childrenCount; j > i; j--) {
            node.children[j] = node.children[j - 1];
        }

        node.children[i] = t;
        node.childrenCount++;

        if (node.childrenCount < MAX_CHILDREN) {
            return null;
        } else {
            return split(node);
        }
    }

    private Node split(Node node) {
        Node t = new Node(MAX_CHILDREN / 2);
        node.childrenCount = MAX_CHILDREN / 2;

        for (int i = 0; i < MAX_CHILDREN / 2; i++) {
            t.children[i] = node.children[i + MAX_CHILDREN / 2];
        }

        return t;
    }

    public int height() {
        return height;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return KVPairs;
    }

    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.childrenCount; j++) {
                s.append(indent).append(children[j].key).append(" ").append(children[j].val).append("\n");
            }
        } else {
            for (int j = 0; j < h.childrenCount; j++) {
                if (j > 0) {
                    s.append(indent).append("(").append(children[j].key).append(")\n");
                }

                s.append(toString(children[j].next, ht - 1, indent + "     "));
            }
        }

        return s.toString();
    }

    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    static class Node {
        int childrenCount;
        Entry[] children = new Entry[MAX_CHILDREN];

        public Node(int childrenCount) {
            this.childrenCount = childrenCount;
        }
    }

    static class Entry {
        Comparable key;
        Object val;
        Node next;

        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
