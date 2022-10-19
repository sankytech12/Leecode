//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
         ArrayList<Integer> ans=new  ArrayList<Integer>();
         int ei=0,si=0;
         HashMap<Integer,Integer> map=new HashMap<>();
         
         while(ei<A.length){
             int ele=A[ei];
             map.put(ele,map.getOrDefault(ele,0)+1);
             while(ei-si+1>k && si<=ei){
                 int rv=A[si];
                 map.put(rv,map.get(rv)-1);
                 if(map.get(rv)==0) map.remove(rv);
                 si++;
             }
             if(ei-si+1==k){
                 ans.add(map.size());
             }
             ei++;
         }
         return ans;
    }
}

