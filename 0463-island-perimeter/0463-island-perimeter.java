class Solution {
    public int islandPerimeter(int[][] grid) {

        int land = 0;
        int shared = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {

                    land++;

                    // Check down
                    if (i + 1 < grid.length && grid[i + 1][j] == 1)
                        shared++;

                    // Check right
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1)
                        shared++;
                }
            }
        }

        return land * 4 - shared * 2;
    }
}