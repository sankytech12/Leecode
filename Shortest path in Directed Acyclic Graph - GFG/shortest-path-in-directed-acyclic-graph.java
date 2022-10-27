//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		return solve(edges,N,M);
		
	}
	static class Pair{
		int v;
		int cost;
		public Pair(int v,int cost) {
			// TODO Auto-generated constructor stub
			this.v=v;
			this.cost=cost;
		}
	}
	static class DPair{
		int v;
		int acq;
		int c;
		DPair(int v,int acq,int c){
			this.v=v;
			this.acq=acq;
			this.c=c;
		}
	}
	private static int[] solve(int[][] edges,int n,int m) {
		// TODO Auto-generated method stub
		int ans[]=new int[n];
		ArrayList<ArrayList<Pair>> ll=new ArrayList<>();
		for(int i=0;i<n;i++) {
			ArrayList<Pair> temp=new ArrayList<>();
			ll.add(temp);
		}
		for (int i = 0; i < edges.length; i++) {
			int e1=edges[i][0],e2=edges[i][1],c=edges[i][2];
			ll.get(e1).add(new Pair(e2, c));
		}
		PriorityQueue<DPair> pq=new PriorityQueue<>(new Comparator<DPair>() {

			@Override
			public int compare(DPair o1, DPair o2) {
				// TODO Auto-generated method stub
				return o1.c-o2.c;
			}
		});
		HashSet<Integer> hs=new HashSet<Integer>();
		pq.add(new DPair(0,0,0));
		while(!pq.isEmpty()) {
			DPair rv=pq.remove();
			if(hs.contains(rv.v)) continue;
			ans[rv.acq]=rv.c;
			hs.add(rv.v);
			for(Pair nbrs:ll.get(rv.v)) {
				if(!hs.contains(nbrs.v)) {
					int cost=rv.c+nbrs.cost;
					DPair nn=new DPair(nbrs.v, nbrs.v, cost);
					pq.add(nn);
				}
			}
		}
		for(int i=1;i<ans.length;i++){
		    if(ans[i]==0) ans[i]=-1;
		}
		return ans;
	}
}