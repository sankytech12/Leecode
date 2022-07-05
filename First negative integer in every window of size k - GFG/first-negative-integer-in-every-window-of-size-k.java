// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int N, int K)
    {
       
       LinkedList<Integer> ll = new LinkedList<>();

		long[] ans = new long[arr.length - K + 1];
		for (int i = 0; i < K; i++) {
			if (arr[i] < 0) {
				ll.add(i);
			}
		}
		int t = 0;
		if (ll.size() > 0) {
			ans[t++] = arr[ll.peek()];
		} else {

			ans[t++] = 0;
		}
		for (int i = K; i < arr.length; i++) {
			if (!ll.isEmpty() && i - ll.peek() >= K) {
				ll.remove();
			}
			if (arr[i] < 0) {
				ll.add(i);
			}

			if (ll.size() > 0) {
				ans[t++] = arr[ll.peek()];
			} else {

				ans[t++] = 0;
			}

		}
		return ans;
    }
}