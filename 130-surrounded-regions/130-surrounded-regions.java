class Solution {
    public void solve(char[][] mat) {
        int n=mat.length,m=mat[0].length;
        int [][]vis=new int[n][m];
        int []dr={0,0,1,-1};
        int []dc={1,-1,0,0};
        for(int j=0;j<m;j++){
            if(mat[0][j]=='O' && vis[0][j]==0){
                dfs(mat,vis,dr,dc,0,j);
            }
            if(mat[n-1][j]=='O' && vis[n-1][j]==0){
                dfs(mat,vis,dr,dc,n-1,j);
            }
        }
        for(int i=0;i<n;i++){
            if(mat[i][0]=='O' && vis[i][0]==0){
                 dfs(mat,vis,dr,dc,i,0);
            }
            if(mat[i][m-1]=='O' && vis[i][m-1]==0){
                 dfs(mat,vis,dr,dc,i,m-1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && mat[i][j]=='O'){
                    mat[i][j]='X';
                }
            }
        }
       // return mat;
    }
    public static void dfs(char [][]mat,int [][]vis,int []dr,int dc[],int row,int col){
        vis[row][col]=1;
        int n=mat.length,m=mat[0].length;
        for(int i=0;i<dr.length;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 && nr<n &&nc>=0 && nc<m && vis[nr][nc]==0 && mat[nr][nc]=='O'){
                dfs(mat,vis,dr,dc,nr,nc);
            }
        }
    }
    
}