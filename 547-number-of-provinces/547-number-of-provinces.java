class Solution {
    public int findCircleNum(int[][] isConnected) {
        return solve2(isConnected);
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
    private static int solve2(int[][] arr) {
		HashSet<Integer> hs=new HashSet<Integer>();
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			if(!hs.contains(i)) {
				count++;
				dft(arr,i,hs);
			}
		}return count;
	}

	private static void dft(int[][] arr, int node, HashSet<Integer> hs) {
		// TODO Auto-generated method stub
		hs.add(node);
		for (int i = 0; i < arr[node].length; i++) {
			if(arr[node][i]==1 && node!=i) {
				if(!hs.contains(i)) {
					dft(arr, i, hs);
				}
				
			}
		}
	}
}