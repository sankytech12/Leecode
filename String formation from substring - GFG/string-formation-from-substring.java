//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.isRepeat(input);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isRepeat(String s) {
        // code here
        int []lps=new int[s.length()];
        compute(lps,s);
        int ans=lps[lps.length-1];
        return (ans>0 && s.length()%(s.length()-ans)==0)?1:0;
    }
    void compute(int[] lps,String s){
        int len=0;
        int i=1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i++]=len;
            }
            else{
                if(len==0) lps[i++]=0;
                else len=lps[len-1];
            }
        }
    }
}