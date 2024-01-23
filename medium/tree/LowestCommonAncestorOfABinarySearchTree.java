package medium.tree;

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.left.right = new TreeNode(9);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        System.out.println(lowestCommonAncestor(root, p, q));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);

        TreeNode p2 = new TreeNode(2);
        TreeNode q2 = new TreeNode(1);

        System.out.println(lowestCommonAncestor(root2, p2, q2));

        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(4);
        root3.right.left = new TreeNode(2);

        TreeNode p3 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);

        System.out.println(lowestCommonAncestor(root3, p3, q3));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
