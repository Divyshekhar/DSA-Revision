// this is used to check if the graph contains cycle or not, if the topo sort gives the same number of elements as the vertex that means no cycle else contains cycle

import java.util.*;

class Topo {

    public int[] topoSort(int v, List<List<Integer>> adj) {
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        int[] topoSort = new int[v];
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            topoSort[index++] = node;
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }
        if (index == v) {
            return topoSort;
        }
        return new int[0];
    }

    public static void main(String[] args) {

    }
}
