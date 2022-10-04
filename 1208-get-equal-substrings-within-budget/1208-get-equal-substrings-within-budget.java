class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        return solve(s,t,maxCost);
    }
    private static int solve(String s, String t, int cost) {
		// TODO Auto-generated method stub
		//if(s.equals(t)) return 0;
		int ei=0,si=0;
		int sum=0;
		int ans=0;
		while(ei<s.length()) {
			sum+=Math.abs(s.charAt(ei)-t.charAt(ei));
			while(sum>cost) {
				sum-=Math.abs(s.charAt(si)-t.charAt(si));
				si++;
			}
			ans=Math.max(ans, ei-si+1);
			ei++;
		}
		return ans;
	}
}