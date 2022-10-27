//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static class Pair{
		int v1;
		int v2;
		int c;
		Pair(int v1,int v2,int c){
			this.v1=v1;
			this.v2=v2;
			this.c=c;
		}
	}
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<Pair> ll=new ArrayList<>();
		for (int i = 0; i < edges.length; i++) {
			int e1=edges[i][0],e2=edges[i][1];
			Pair nn1 =new Pair(e1,e2,1);
			Pair nn2 =new Pair(e2,e1,1);
			ll.add(nn1);
			ll.add(nn2);
		}
		int []dsu=new int[n];
		for (int i = 0; i < dsu.length; i++) {
			if(i!=src) dsu[i]=(int)(10e7);
		}
		
		for(int i=1;i<=n;i++) {
			for(Pair ed:ll) {
				int e1=ed.v1,e2=ed.v2;
				int oldc=dsu[e2];
				int newc=dsu[e1]+ed.c;
				if(oldc>newc) {
					dsu[e2]=newc;
				}
			}
		}
		for (int i = 0; i < dsu.length; i++) {
			if(dsu[i]==(int)(10e7)) dsu[i]=-1;
		}
		return dsu;
    }
}