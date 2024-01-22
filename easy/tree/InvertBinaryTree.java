package easy.tree;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        invertTree(root.left);
        root.right = temp;
        invertTree(root.right);

        return root;
    }
}
