class Solution {
    public boolean canFinish(int v, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
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
        return topo.size()==v;
    }
}