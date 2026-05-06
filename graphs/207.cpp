/* There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible. */

#include <bits/stdc++.h>
using namespace std;

bool dfs(int node, vector<vector<int>> &adj, vector<int> &vis, vector<int> &pathVis)
{
    vis[node] = 1;
    pathVis[node] = 1;
    for (auto it : adj[node])
    {
        if (!vis[it])
        {
            if (dfs(it, adj, vis, pathVis))
                return true;
        }
        else if (pathVis[it] == 1)
        {
            return true;
        }
    }
    pathVis[node] = 0;
    return false;
}

bool canComplete(int numCourses, vector<vector<int>> &pre)
{
    vector<vector<int>> adj(numCourses);
    for (auto it : pre)
    {
        adj[it[1]].push_back(it[0]);
    }
    vector<int> vis(numCourses, 0);
    vector<int> pathVis(numCourses, 0);
    for (int i = 0; i < numCourses; i++)
    {
        if (!vis[i])
        {
            if (dfs(i, adj, vis, pathVis))
                return false;
        }
    }
    return true;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
}