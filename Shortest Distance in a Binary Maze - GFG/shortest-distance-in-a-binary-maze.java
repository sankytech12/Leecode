//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        return solve(grid,source,destination);
    }
    static class Pairs {
		int ff, ss, tt;

		Pairs(int ff, int ss, int tt) {
			this.ff = ff;
			this.ss = ss;
			this.tt = tt;
		}
	}

	private static int solve(int[][] maze, int[] src, int[] des) {
		// TODO Auto-generated method stub
		// if(maze[des[0]][des[1]]==0) return -1;
		int[][] hs = new int[maze.length][maze[0].length];
		LinkedList<Pairs> qq = new LinkedList<>();
		int dr[] = { 0, 0, 1, -1 };
		int dc[] = { 1, -1, 0, 0 };
		qq.add(new Pairs(src[0], src[1], 0));
		while (!qq.isEmpty()) {
			Pairs rv = qq.remove();
			if (rv.ff == des[0] && rv.ss == des[1])
				return rv.tt;
			for (int i = 0; i < dc.length; i++) {
				int newr = rv.ff + dr[i];
				int newc = rv.ss + dc[i];
				if (newr >= 0 && newr < maze.length && newc >= 0 && newc < maze[0].length && maze[newr][newc] == 1) {
					if (hs[newr][newc] == 0) {
						hs[newr][newc] = 1;
						qq.add(new Pairs(newr, newc, rv.tt + 1));
					}
				}

			}
		}
		return -1;
	}
}
