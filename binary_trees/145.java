
import binary_trees.TreeNode;
import java.util.*;

/* Postorder Traversal*/
class binary_trees {

    /* Recursive Solution*/
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        List<Integer> left = postorderTraversalRecursive(root.left);
        List<Integer> right = postorderTraversalRecursive(root.right);
        ans.addAll(left);
        ans.addAll(right);
        ans.add(root.val);
        return ans;
    }

    public static void main(String[] args) {

    }
}
