
import binary_trees.TreeNode;
import java.util.*;

/* Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom. */
 /* */
class binary_trees {

    private void recursiveRight(TreeNode node, int level, List<Integer> right) {
        if (node == null) {
            return;
        }
        if (right.size() == level) {
            right.add(node.val);
        }
        recursiveRight(node.right, level + 1, right);
        recursiveRight(node.left, level + 1, right);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new ArrayList<>();
        recursiveRight(root, 0, right);
        return right;
    }

    private void recursiveLeft(TreeNode node, int level, List<Integer> left) {
        if (node == null) {
            return;
        }
        if (left.size() == level) {
            left.add(node.val);
        }
        recursiveLeft(node.left, level + 1, left);
        recursiveLeft(node.right, level + 1, left);
    }

    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        recursiveLeft(root, 0, left);
        return left;
    }

    public static void main(String[] args) {

    }
}
