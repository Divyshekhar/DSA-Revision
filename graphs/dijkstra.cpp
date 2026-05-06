#include <bits/stdc++.h>
using namespace std;
vector<int> dijkstra(int v, vector<vector<int>> adj[], int src)
{
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    vector<int> dist(v);
    for (int i = 0; i < v; i++)
        dist[i] = 1e9;
    dist[src] = 0;
    pq.push({0, src});
    while (!pq.empty())
    {
        int dis = pq.top().first;
        int node = pq.top().second;
        pq.pop();
        for (auto it : adj[node])
        {
            int edgeWt = it[1];
            int adjNode = it[0];
            if (dis + edgeWt < dist[adjNode])
            {
                dist[adjNode] = dis + edgeWt;
                pq.push({dist[adjNode], adjNode});
            }
        }
    }
    return dist;
}

vector<int> shortestParth(int n, int m, vector<vector<int>> &edges)
{
    vector<pair<int, int>> adj[n+1];
    for(auto it : edges){
        adj[it[0]].push_back({it[1], it[2]});
        adj[it[1]].push_back({it[0], it[2]});
    }
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    vector<int> dist(n+1, 1e9);
    dist[1] = 0;
    vector<int> parent(n+1);
    for(int i = 1; i<=n; i++){
        parent[i] = i;
    }
    pq.push({0, 1});
    while(!pq.empty()){
        auto it = pq.top();
        int node = it.second;
        int dis = it.first;
        pq.pop();
        for(auto it : adj[node]){
            int adjNode = it.first;
            int edgeWt = it.second;
            if(dis + edgeWt < dist[adjNode]){
                dist[adjNode] = dis+edgeWt;
                pq.push({dist[adjNode], adjNode});
                parent[adjNode] = node;
            }
        }
    }
    if(dist[n] == 1e9){
        return {-1};
    }
    vector<int> path;
    int node = n;
    while(parent[node] != node){
        path.push_back(node);
        node = parent[node];
    }
    path.push_back(1);
    reverse(path.begin(), path.end());
    return path;

}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
}