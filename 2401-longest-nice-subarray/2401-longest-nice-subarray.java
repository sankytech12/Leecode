class Solution {
    public int longestNiceSubarray(int[] n) {
		// TODO Auto-generated method stub
		int ei=0,si=0,ans=0,num=0;
		while(ei<n.length) {
			while((num & n[ei])!=0 && si<=ei) {
				num^=n[si];
				si++;
			}
			num|=n[ei];
			ans=Math.max(ans, ei-si+1);
			ei++;
		}
		//System.out.println(ans);
		return ans;
	
        
    }
}