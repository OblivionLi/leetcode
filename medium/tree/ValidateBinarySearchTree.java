package medium.tree;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isValidBST(root));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println(isValidBST(root2));

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);

        System.out.println(isValidBST(root3));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode node, TreeNode lower, TreeNode upper) {
        if (node == null) {
            return true;
        }

        if ((lower != null && node.val <= lower.val) || (upper != null && node.val >= upper.val)) {
            return false;
        }

        return isValid(node.left, lower, node) && isValid(node.right, node, upper);
    }
}
