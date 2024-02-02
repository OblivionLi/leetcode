package easy.tree;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {
    }

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
//        TreeNode2 tree = new TreeNode2(1);
//        tree.left = new TreeNode2(2);
//        tree.left.left = new TreeNode2(4);
//        tree.left.right = new TreeNode2(5);
//        tree.right = new TreeNode2(3);
//
//        System.out.println(diameterOfBinaryTree(tree));

        TreeNode2 tree2 = new TreeNode2(1);
        tree2.left = new TreeNode2(2);

        System.out.println(diameterOfBinaryTree(tree2));
    }

    public static int diameterOfBinaryTree(TreeNode2 root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(leftDepth + rightDepth, Math.max(leftDiameter, rightDiameter));
    }

    private static int depth(TreeNode2 node) {
        if (node == null) {
            return 0;
        }

        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
