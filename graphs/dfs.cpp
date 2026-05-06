#include<bits/stdc++.h>
using namespace std;
void dfs(int node, vector<int> adj[], vector<bool> &visited){
    visited[node] = true;
    cout << node << " ";
    for(auto it : adj[node]){
        if(!visited[it]){
            dfs(it, adj, visited);
        }
    }
}

int main(){
   ios_base::sync_with_stdio(false);
   cin.tie(nullptr);
   vector<int> adj[100]; // Adjacency list for the graph
    int V, E; // Number of vertices and edges  
    cin >> V >> E; // Input number of vertices and edges
    for(int i = 0; i < E; i++){
        int u, v; // Edge from u to v
        cin >> u >> v; // Input edge
        adj[u].push_back(v); // Add v to u's adjacency list
        adj[v].push_back(u); // Add u to v's adjacency list (for undirected graph)
    }
    vector<bool> visited(V, false); // Visited array to keep track of visited nodes
    for(int i = 0; i < V; i++){
        if(!visited[i]){
            dfs(i, adj, visited); // Perform DFS starting from node i
        }
    }
   return 0;
}
