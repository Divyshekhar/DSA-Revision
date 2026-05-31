
import java.util.*;

class graphs {

    public int[] dijkstra(int[][] graph, int src, int V) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : graph){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[] {v, wt});
            adj.get(v).add(new int[] {u, wt});
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // min heap 
        pq.offer(new int[] {src, 0});
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0];
            int d = top[1];
            if(d > dist[node]) continue;
            for(int[] next : adj.get(node)){
                int v = next[0];
                int wt = next[1];
                if(wt + dist[node] < dist[v]){
                    dist[v] = wt + dist[node];
                    pq.offer(new int[] {v, dist[v]});
                }                
            }
        }
        return dist;
    }

    public static void main(String[] args) {

    }
}
