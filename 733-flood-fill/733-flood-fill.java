class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return solve(image,sr,sc,color);
    }
    private static int[][] solve(int[][] im, int sr, int sc, int nc) {
		// TODO Auto-generated method stub
		int [][]ans=im;
		int ini=im[sr][sc];
		int []dr= {0,0,1,-1};
		int []dc= {1,-1,0,0};	
		dfs(im,ans,sr,sc,nc,ini,dr,dc);
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
}