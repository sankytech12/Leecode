class Solution {
    public int[] findOrder(int v, int[][] arr) {
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        int []ind=new int[v];
        for(int i=0;i<v;i++){
            for(int j:adj.get(i)){
                ind[j]++;
            }
        }
        LinkedList<Integer> qq=new LinkedList<>();
        ArrayList<Integer> topo=new ArrayList<>();
        for(int i=0;i<v;i++){
            if(ind[i]==0) qq.add(i);
        }
        while(!qq.isEmpty()){
            int rv=qq.remove();
            topo.add(rv);
            for(int nbrs:adj.get(rv)){
                ind[nbrs]--;
                if(ind[nbrs]==0){
                    qq.add(nbrs);
                }
            }
        }
       
        int ans[]=new int[topo.size()];
       // System.out.print(topo);
        for(int i=0;i<ans.length;i++){
            ans[i]=topo.get(i);
        }
         if(topo.size()!=v) ans=new int[0];
        return ans;
    }
}