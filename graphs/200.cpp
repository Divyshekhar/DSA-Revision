/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
*/

#include <bits/stdc++.h>
using namespace std;
void dfs(int row, int col, vector<vector<char>> &grid, vector<vector<bool>> &vis)
{
    vis[row][col] = true;
    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, -1, 0, 1};
    for (int i = 0; i < 4; i++)
    {
        int new_row = row + dr[i];
        int new_col = col + dc[i];
        if (new_row >= 0 && new_row < grid.size() && new_col >= 0 && new_col < grid[0].size() && grid[new_row][new_col] == '1' && !vis[new_row][new_col])
        {
            dfs(new_row, new_col, grid, vis);
        }
    }
}
int numIslands(vector<vector<char>> &grid)
{
    int m = grid.size();
    int n = grid[0].size();
    vector<vector<bool>> vis(m, vector<bool>(n, false));
    int cnt = 0;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (grid[i][j] == '1' && !vis[i][j])
            {
                cnt++;
                dfs(i, j, grid, vis);
            }
        }
    }
    return cnt;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
}