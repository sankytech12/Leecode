//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
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
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int []ans=new int[V];
       PriorityQueue<DPair> pq=new PriorityQueue<>(new Comparator<DPair>() {

			@Override
			public int compare(DPair o1, DPair o2) {
				// TODO Auto-generated method stub
				return o1.c-o2.c;
			}
		});
		HashSet<Integer> hs=new HashSet<Integer>();
		pq.add(new DPair(S,S,0));
		while(!pq.isEmpty()){
		    DPair rv=pq.remove();
		    if(hs.contains(rv.v)) continue;
		    hs.add(rv.v);
		    ans[rv.v]=rv.c;
		    for(int i=0;i<adj.get(rv.v).size();i++){
		        int ele=adj.get(rv.v).get(i).get(0);
		        int cost=adj.get(rv.v).get(i).get(1);
		        if(!hs.contains(ele)){
		            DPair nn=new DPair(ele,ele,rv.c+cost);
		            pq.add(nn);
		        }
		    }
		}
		return ans;
    }
}

