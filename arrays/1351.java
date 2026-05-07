/*
    Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 */

class arrays {
    // the array is sorted both row wise and column wise thats why going from the bottom left
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = m - 1;
        int j = 0;
        int cnt = 0;
        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                cnt += n - j;
                i--;
            } else {
                j++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
