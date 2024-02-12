package medium.tree;

import java.util.Stack;

public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        int k = 1;

        System.out.println(kthSmallest(root, k));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(2);
        root2.left.left.left = new TreeNode(1);
        root2.right = new TreeNode(6);
        root2.left.right = new TreeNode(4);

        int k2 = 3;

        System.out.println(kthSmallest(root2, k2));

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(3);
        root3.left.left = new TreeNode(2);
        root3.right = new TreeNode(6);
        root3.right.right = new TreeNode(7);
        root3.left.right = new TreeNode(4);

        int k3 = 3;

        System.out.println(kthSmallest(root3, k3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;

            if (k == 0) {
                return root.val;
            }

            root = root.right;
        }
    }
}
