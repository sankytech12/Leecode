class Solution {
    static class Pair{
		int first;
		int second;
		public Pair(int first,int second) {
			// TODO Auto-generated constructor stub
			this.first=first;
			this.second=second;
		}
	}
    public int numIslands(char[][] grid) {
     
		int [][]vis=new int[grid.length][grid[0].length];
		int count=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]=='1' && vis[i][j]==0) {
					count++;
					bfs(grid,i,j,vis);
				}
			}
		}
		return count;
    }
        
   	private static void bfs(char[][] grid, int i, int j, int[][] vis) {
	   //TODO Auto-generated method stub
		LinkedList<Pair> qq=new LinkedList<>();
		vis[i][j]=1;
		qq.add(new Pair(i, j));
		while(!qq.isEmpty()) {
			Pair rv=qq.remove();
			int row=rv.first;
			int col=rv.second;
            int r[]={0,1,0,-1};
            int c[]={1,0,-1,0};
			// for (int dr = -1; dr <=1; dr++) {
			// 	for (int dc = -1; dc <=1; dc++){
                for(int k=0;k<r.length;k++){
                  //  if(dr!=0 && dc!=0 && dr==dc) continue;
					int nr=r[k]+row;
					int nc=c[k]+col;
					if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1' && vis[nr][nc]==0) {
						vis[nr][nc]=1;
						qq.add(new Pair(nr,nc));
					}
				}		
			
		}
		
		
	}

}