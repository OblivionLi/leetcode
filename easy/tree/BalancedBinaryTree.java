package easy.tree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        System.out.println(isBalanced(root));

//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(2);
//        root2.left.left = new TreeNode(3);
//        root2.left.left.left = new TreeNode(4);
//        root2.right = new TreeNode(2);
//        root2.left.right = new TreeNode(3);
//        root2.left.left.right = new TreeNode(4);
//
//        System.out.println(isBalanced(root2));
//
//        TreeNode root3 = new TreeNode(1);
//
//        System.out.println(isBalanced(root3));
//
//        System.out.println(isBalanced(new TreeNode()));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkBalanced(root) != -1;
    }

    private static int checkBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkBalanced(root.left);
        int rightHeight = checkBalanced(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
