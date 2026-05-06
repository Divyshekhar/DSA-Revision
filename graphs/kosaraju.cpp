#include <bits/stdc++.h>
using namespace std;
void dfs1(int node, vector<vector<int>> &adj, vector<int> &vis, stack<int> &st)
{
    vis[node] = 1;
    for (auto it : adj[node])
    {
        if (!vis[it])
        {
            dfs1(it, adj, vis, st);
        }
    }
    st.push(node);
}

void dfs2(int node, vector<vector<int>> &adjT, vector<int> &vis)
{
    vis[node] = 1;
    for (auto it : adjT[node])
    {
        if (!vis[it])
        {
            dfs2(it, adjT, vis);
        }
    }
}

int kosaraju(int v, vector<vector<int>> &adj)
{
    vector<int> vis(v, 0);
    stack<int> st;
    for (int i = 0; i < v; i++)
    {
        if (!vis[i])
        {
            dfs1(i, adj, vis, st);
        }
    }

    vector<vector<int>> adjT(v);
    for (int i = 0; i < v; i++)
    {
        vis[i] = 0;
        for (auto it : adj[i])
        {
            adjT[it].push_back(i);
        }
    }
    int scc = 0;
    while (!st.empty())
    {
        int node = st.top();
        st.pop();
        if (!vis[node])
        {
            scc++;
            dfs2(node, adjT, vis);
        }
    }
    return scc;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
}