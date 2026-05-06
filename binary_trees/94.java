import binary_trees.TreeNode;
import java.util.*;
/* Inorder traversal*/
class binary_trees {

    /* Recursive solution*/
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        List<Integer> left = inorderTraversalRecursive(root.left);
        left.add(root.val);
        List<Integer> right = inorderTraversalRecursive(root.right);
        ans.addAll(left);
        ans.addAll(right);
        return ans;
    }

    public static void main(String[] args) {

    }
}
