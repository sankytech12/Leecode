class Solution {
    public String shortestPalindrome(String s) {
        if(s.length()==0) return "";
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb.reverse();
        String ns=s+"#"+sb.toString();
        int []lps=new int[ns.length()];
        int c=-1;
        int len=0;
        int i=1;
        while(i<ns.length()){
            if(ns.charAt(i)==ns.charAt(len)){
                len++;
                c=Math.max(c, len);
                lps[i++]=len;
            }else{
                if(len==0) lps[i++]=0;
                else len=lps[len-1];
            }
        }
        if(lps[lps.length-1]==s.length()){
            return s;
        }
        sb.delete(0, sb.length());
        sb.append(s.substring(lps[lps.length-1], s.length()));
        sb.reverse();
        String ans=sb.toString()+s;
        return ans;
    }
}