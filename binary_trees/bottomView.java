
import binary_trees.TreeNode;
import java.util.*;


/* 
    Bottom view of binary tree
 */
class bottomView {

    // in this both dfs and bfs can work 
    // bfs easier because it will go level by level and hence the deeper layer comes last
    // in dfs maintain the depth level as well as the x-axis level
    class Pair {

        public TreeNode node;
        public int x;

        public Pair(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public List<Integer> bfsSolution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            TreeNode node = top.node;
            int x = top.x;

            map.put(x, node.val);
            if (node.left != null) {
                q.offer(new Pair(node.left, x - 11));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, x + 1));
            }
        }
        for (int val : map.values()) {
            res.add(val);
        }
        return res;
    }

    public List<Integer> bottomView(TreeNode root) {
        return bfsSolution(root);
    }

    public static void main(String[] args) {

    }
}
