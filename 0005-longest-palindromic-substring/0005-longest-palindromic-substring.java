class Solution {
    public String longestPalindrome(String s) {
        return solve(s);
    }
     private static String solve(String s) {
        boolean dp[][]=new boolean[s.length()][s.length()];
        int ans=0;
        String a="";
        for (int g = 0; g < dp.length; g++) {
            for(int i=0,j=g;j<dp.length;i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }else if(g==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }
                if(dp[i][j]){
                    if(ans<j-i+1){
                        ans=j-i+1;
                        a=s.substring(i, j+1);
                    }
                }
            }
        }
        return a;
    }
}