class Solution {

    class Cell {
        int row, col, height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3)
            return 0;

        PriorityQueue<Cell> pq =
            new PriorityQueue<>((a, b) -> a.height - b.height);

        boolean[][] visited = new boolean[m][n];

        // Add first & last columns
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        // Add first & last rows
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int water = 0;

        int[][] dir = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        while (!pq.isEmpty()) {

            Cell curr = pq.poll();

            for (int[] d : dir) {

                int x = curr.row + d[0];
                int y = curr.col + d[1];

                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y])
                    continue;

                visited[x][y] = true;

                water += Math.max(0, curr.height - heightMap[x][y]);

                pq.offer(new Cell(
                    x,
                    y,
                    Math.max(curr.height, heightMap[x][y])
                ));
            }
        }

        return water;
    }
}