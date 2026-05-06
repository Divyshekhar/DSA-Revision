
import binary_trees.TreeNode;
import java.util.*;

/* Preorder Traversal*/
class binary_trees {


    /* Recursive solution*/
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        List<Integer> left = preorderTraversalRecursive(root.left);
        List<Integer> right = preorderTraversalRecursive(root.right);
        ans.addAll(left);
        ans.addAll(right);
        return ans;
    }

    public static void main(String[] args) {

    }
}
