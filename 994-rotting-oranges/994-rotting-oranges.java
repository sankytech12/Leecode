class Solution {
    class Pair{
        int r,c,t;
        Pair(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
 
    public int orangesRotting(int[][] grid) {
         int [][]vis=new int[grid.length][grid[0].length];
		LinkedList<Pair> qq=new LinkedList<>();
		int countFresh=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]==2) {
					vis[i][j]=2;
					qq.add(new Pair(i, j, 0));
				}
				if(grid[i][j]==1) {
					countFresh++;
				}
			}
		}
		int tm=0;
		int cnt=0;
		int dr[]= {0,0,1,-1};
		int []dc= {1,-1,0,0};
		while(!qq.isEmpty()) {
			Pair rv=qq.remove();
			int row=rv.r,col=rv.c,time=rv.t;
			tm=Math.max(tm, time);
			for (int i = 0; i < dc.length; i++) {
				int newr=row+dr[i];
				int newc=col+dc[i];
				if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length && grid[newr][newc]==1 && vis[newr][newc]==0) {
					vis[newr][newc]=2;
					qq.add(new Pair(newr, newc, time+1));
					cnt++;
				}
					
			}
		}
		if(cnt!=countFresh) return -1;
		return tm;
    }
    
}