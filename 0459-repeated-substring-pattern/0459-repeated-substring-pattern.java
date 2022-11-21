class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int []lps=new int[s.length()];
        compute(lps,s);
        int ans=lps[lps.length-1];
        return (ans>0 && s.length()%(s.length()-ans)==0);
    }
    void compute(int []lps,String s){
        int len=0;
        int i=1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i++]=len;
            }else{
                if(len==0) lps[i++]=0;
                else len=lps[len-1];
            }
        }
    }
}