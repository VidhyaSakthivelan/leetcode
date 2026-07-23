class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        int id = 2;

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                if(grid[i][j]==1){

                    map.put(id,dfs(grid,i,j,id));

                    id++;
                }
            }
        }

        int ans = 0;

        for(int size : map.values())
            ans=Math.max(ans,size);

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                if(grid[i][j]==0){

                    HashSet<Integer> set=new HashSet<>();

                    int area=1;

                    for(int[] d:dir){

                        int x=i+d[0];
                        int y=j+d[1];

                        if(x>=0&&y>=0&&x<n&&y<n&&grid[x][y]>1){

                            int islandId=grid[x][y];

                            if(set.add(islandId))
                                area+=map.get(islandId);
                        }
                    }

                    ans=Math.max(ans,area);
                }
            }
        }

        return ans==0?n*n:ans;
    }

    private int dfs(int[][] grid,int i,int j,int id){

        if(i<0||j<0||i>=grid.length||j>=grid.length||grid[i][j]!=1)
            return 0;

        grid[i][j]=id;

        int area=1;

        for(int[] d:dir)
            area+=dfs(grid,i+d[0],j+d[1],id);

        return area;
    }
}