
import binary_trees.TreeNode;
import java.util.*;

/* Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer. */
class binary_trees {

    public class Pair {

        public TreeNode node;
        public int val;

        public Pair(TreeNode node, int val) {
            this.node = node;
            this.val = val;
        }

    }

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int minn = q.peek().val;
            int left = 0;
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.peek().node;
                int val = q.peek().val - minn;
                q.poll();
                if (i == 0) {
                    left = val;
                }
                if (i == size-1) {
                    right = val;
                }
                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * val + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * val + 2));
                }

            }
            ans = Math.max(ans, (right - left + 1));
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
