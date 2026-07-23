class Solution {

    class DSU {
        int[] parent;
        int components;

        DSU(int n) {
            parent = new int[n + 1];
            components = n;

            for (int i = 1; i <= n; i++)
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
            components--;

            return true;
        }

        DSU copy() {
            DSU d = new DSU(parent.length - 1);
            d.components = components;
            d.parent = parent.clone();
            return d;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        DSU common = new DSU(n);

        int used = 0;

        // Use all type 3 edges first
        for (int[] e : edges) {

            if (e[0] == 3) {

                if (common.union(e[1], e[2]))
                    used++;
            }
        }

        DSU alice = common.copy();
        DSU bob = common.copy();

        // Alice edges
        for (int[] e : edges) {

            if (e[0] == 1) {

                if (alice.union(e[1], e[2]))
                    used++;
            }
        }

        // Bob edges
        for (int[] e : edges) {

            if (e[0] == 2) {

                if (bob.union(e[1], e[2]))
                    used++;
            }
        }

        if (alice.components != 1 || bob.components != 1)
            return -1;

        return edges.length - used;
    }
}