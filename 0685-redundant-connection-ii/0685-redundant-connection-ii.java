class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;

        int[] parent = new int[n + 1];

        int[] candidate1 = null;
        int[] candidate2 = null;

        // Step 1: Find node with two parents
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (parent[v] == 0) {

                parent[v] = u;

            } else {

                candidate1 = new int[]{parent[v], v};
                candidate2 = new int[]{u, v};

                edge[1] = 0;   // Ignore second edge temporarily
            }
        }

        // Step 2: Union Find
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {

            if (edge[1] == 0)
                continue;

            int u = edge[0];
            int v = edge[1];

            if (!uf.union(u, v)) {

                // Case 2: Cycle only
                if (candidate1 == null)
                    return edge;

                // Case 3: Two parents + cycle
                return candidate1;
            }
        }

        // Case 1: Two parents only
        return candidate2;
    }

    class UnionFind {

        int[] parent;

        UnionFind(int n) {

            parent = new int[n + 1];

            for (int i = 0; i <= n; i++)
                parent[i] = i;
        }

        int find(int x) {

            if (parent[x] != x)
                parent[x] = find(parent[x]);

            return parent[x];
        }

        boolean union(int x, int y) {

            int px = find(x);
            int py = find(y);

            if (px == py)
                return false;

            parent[py] = px;

            return true;
        }
    }
}