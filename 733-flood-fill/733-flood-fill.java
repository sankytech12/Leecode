class Solution {
     static class Pair{
		int first,second;
		public Pair(int first,int second) {
			// TODO Auto-generated constructor stub
			this.first=first;
			this.second=second;
		}
	}
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return solve(image,sr,sc,color);
    }
    private static int[][] solve(int[][] im, int sr, int sc, int nc) {
		// TODO Auto-generated method stub
		int [][]ans=im;
		int ini=im[sr][sc];
		int []dr= {0,0,1,-1};
		int []dc= {1,-1,0,0};	
		bfs(im,ans,sr,sc,nc,ini,dr,dc);
		return ans;
	}

	private static void dfs(int[][] im, int[][] ans, int sr, int sc, int nc, int ini, int[] dr, int[] dc) {
		// TODO Auto-generated method stub
		ans[sr][sc]=nc;
		for(int i=0;i<dr.length;i++) {
			int newr=dr[i]+sr;
			int newc=dc[i]+sc;
			if(newr>=0 && newr<im.length && newc>=0 && newc<im[0].length && im[newr][newc]==ini && ans[newr][newc]!=nc) {
				dfs(im, ans, newr, newc, nc, ini, dr, dc);
			}
		}
	}
   private static void bfs(int[][] im, int[][] ans, int sr, int sc, int nc, int ini, int[] dr, int[] dc) {
		// TODO Auto-generated method stub
		LinkedList<Pair> qq=new LinkedList<>();
		
		qq.add(new Pair(sr, sc));
		while(!qq.isEmpty()) {
			Pair rv=qq.remove();
			int row=rv.first;
			int col=rv.second;
			ans[row][col]=nc;
			for (int i = 0; i < dc.length; i++) {
				int newr=row+dr[i];
				int newc=col+dc[i];
				if(newr>=0 && newr<im.length && newc>=0 && newc<im[0].length && im[newr][newc]==ini && ans[newr][newc]!=nc) {
					qq.add(new Pair(newr, newc));
				}
			}
		}
		
	}
}