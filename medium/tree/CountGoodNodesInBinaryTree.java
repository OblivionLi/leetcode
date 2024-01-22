package medium.tree;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private static int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val >= maxSoFar) {
            count++;
            maxSoFar = node.val;
        }

        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        return count;
    }
}
