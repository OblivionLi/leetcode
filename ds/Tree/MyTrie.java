package ds.Tree;

public class MyTrie {
    Node root;

    public MyTrie() {
        this.root = new Node('\0');
    }

    static class Node {
        Node[] children;
        boolean isWord;
        char value;

        public Node(char value) {
            this.value = value;
            children = new Node[26];
            isWord = false;
        }

        @Override
        public String toString() {
            return "Node{" +
                    ", isWord=" + isWord +
                    ", value=" + value +
                    '}';
        }
    }

    public void insert(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node(c);
            }

            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return true;
    }

    public boolean delete(String word) {
        return deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(Node node, String word, int index) {
        if (index == word.length()) {
            if (!node.isWord) {
                return false;
            }
            node.isWord = false;
            return node.children.length == 0;
        }

        char c = word.charAt(index);
        Node childNode = node.children[c - 'a'];
        if (childNode == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = deleteHelper(childNode, word, index + 1);

        if (shouldDeleteCurrentNode) {
            node.children[c - 'a'] = null;
            return node.children.length == 0;
        }

        return false;
    }

    public void printAllWords() {
        dfs(root, new StringBuilder());
    }

    private void dfs(Node node, StringBuilder prefix) {
        if (node.isWord) {
            System.out.print(prefix.toString() + ", ");
        }

        for (char c = 'a'; c <= 'z'; c++) {
            int index = c - 'a';

            if (node.children[index] != null) {
                prefix.append(c);

                dfs(node.children[index], prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }
}
