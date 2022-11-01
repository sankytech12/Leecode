class Solution {
     int e=1;
     int count=0;
    public int uniquePathsIII(int[][] grid) {
        int si=0,sj=0;   
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    si=i;
                    sj=j;
                }
                else if(grid[i][j]==0) {
                    e++;
                }
            }
        }
        
        solve(grid, si, sj);
        return count;
    }

    private void solve(int [][]grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]<0){
            return ;
        }
        if(grid[i][j]==2){
            if(e==0) count++;
            return;
        }
        int []dr={1,-1,0,0};
        int []dc={0,0,1,-1};
        e--;
        grid[i][j]=-2;
        for (int k = 0; k < dc.length; k++) {
            solve(grid, i+dr[k], j+dc[k]);     
    
        }
        e++;
        grid[i][j]=0;
        
    }
}