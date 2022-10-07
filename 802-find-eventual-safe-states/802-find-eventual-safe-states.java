class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V=adj.length;
         int []vis=new int[V];
        int []pathv=new int[V];
        int []check=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(adj,vis,pathv,check,i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<check.length;i++){
            if(check[i]==1) ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int[][] adj,int []vis,int []pathv,int []check,int x){
        vis[x]=1;
        check[x]=0;
        pathv[x]=1;
        for(int nbrs:adj[x]){
            if(vis[nbrs]==0){
                if(dfs(adj,vis,pathv,check,nbrs)) return true;
            }
            else if(pathv[nbrs]==1){
                return true;
            }
        }
        pathv[x]=0;
        check[x]=1;
        return false;
    }
}