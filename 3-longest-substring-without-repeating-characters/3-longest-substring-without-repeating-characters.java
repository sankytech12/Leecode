class Solution {
    public int lengthOfLongestSubstring(String s) {
        int []frq=new int[256];
        int si=0;
        int ei=0;
        int ans=0;
        while(ei<s.length()){
            char ch=s.charAt(ei);
            frq[ch]++;
            while(frq[ch]>1){
                char c=s.charAt(si);
                frq[c]--;
                si++;
        
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}