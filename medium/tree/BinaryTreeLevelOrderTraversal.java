package medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));

        TreeNode root2 = new TreeNode(1);

        System.out.println(levelOrder(root2));

        TreeNode root3 = new TreeNode();

        System.out.println(levelOrder(root3));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levels = new ArrayList<>();
        levels.add(List.of(root.val));

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            List<Integer> subLevel = new LinkedList<>();
            List<TreeNode> subNode = new ArrayList<>();

            for (TreeNode node : nodes) {
                if (node.left != null) {
                    subLevel.add(node.left.val);
                    subNode.add(node.left);
                }

                if (node.right != null) {
                    subLevel.add(node.right.val);
                    subNode.add(node.right);
                }
            }

            if (!subLevel.isEmpty()) {
                levels.add(subLevel);
            }

            nodes = subNode;
        }

        return levels;
    }
}
