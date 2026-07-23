class Solution {

    int paths = 0;
    int empty = 1;

    public int uniquePathsIII(int[][] grid) {

        int sr = 0, sc = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0)
                    empty++;

                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
            }
        }

        dfs(grid, sr, sc);

        return paths;
    }

    private void dfs(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 ||
            i >= grid.length || j >= grid[0].length ||
            grid[i][j] == -1)
            return;

        if (grid[i][j] == 2) {

            if (empty == 0)
                paths++;

            return;
        }

        grid[i][j] = -1;
        empty--;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        grid[i][j] = 0;
        empty++;
    }
}