
import binary_trees.TreeNode;
import java.util.*;

class topView {

    class Pair {

        TreeNode node;
        int x;

        Pair(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    private List<Integer> bfsSolution(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            TreeNode node = top.node;
            int x = top.x;
            if (!map.containsKey(x)) {
                map.put(x, node.val);
            }
            if (node.left != null) {
                q.offer(new Pair(node.left, x - 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, x + 1));
            }
        }
        for (int vals : map.values()) {
            ans.add(vals);
        }
        return ans;
    }

    public List<Integer> topView(TreeNode root) {
        return bfsSolution(root);
    }

    public static void main(String[] args) {

    }
}
