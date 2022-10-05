class Solution {
    public int findCircleNum(int[][] isConnected) {
        return solve(isConnected);
    }
    	private static int solve(int[][] arr) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]==1 && i!=j) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
		}
		System.out.println(graph);
		int count=0;
		HashSet<Integer> hs=new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(!hs.contains(i)) {
				count++;
				dfs(graph,i,hs);
			}
		}
		return count;
	}
	
	private static void dfs(ArrayList<ArrayList<Integer>> graph, int node, HashSet<Integer> hs) {
		// TODO Auto-generated method stub
		hs.add(node);
		for(int nbrs:graph.get(node)) {
			if(!hs.contains(nbrs)) {
				dfs(graph, nbrs, hs);
			}
		}
	}
}