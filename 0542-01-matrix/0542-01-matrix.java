class Solution {
    class Pair{
        int f,s,d;
        Pair(int f,int s,int d){
            this.f=f;
            this.s=s;
            this.d=d;
        }
    }
    public int[][] updateMatrix(int[][] grid) {
         int n=grid.length,m=grid[0].length;
        int [][]vis=new int[n][m];
        int [][]dist=new int[n][m];
        LinkedList<Pair> qq=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    qq.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int []dr={0,0,1,-1};
        int []dc={1,-1,0,0};
        while(!qq.isEmpty()){
            Pair rv=qq.remove();
            int r=rv.f,c=rv.s,dis=rv.d;
             dist[r][c]=dis;
            for(int i=0;i<dr.length;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    qq.add(new Pair(nr,nc,dis+1));
                }
            }
        }
        return dist;
    }
}