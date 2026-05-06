
import binary_trees.TreeNode;

/* 
    A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

    The path sum of a path is the sum of the node's values in the path.

    Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
class binary_trees {

    int sum = Integer.MIN_VALUE;

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHalf = Math.max(0, maxGain(node.left));
        int rightHalf = Math.max(0, maxGain(node.right));
        sum = Math.max(sum, (leftHalf + rightHalf + node.val));
        return Math.max(leftHalf, rightHalf) + node.val;
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return sum;
    }

    public static void main(String[] args) {

    }
}
