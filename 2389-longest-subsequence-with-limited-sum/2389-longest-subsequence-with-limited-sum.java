class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        return solve(nums,queries);
    }
    private static int[] solve(int[] n, int[] q) {
		// TODO Auto-generated method stub
		//int l=n.length;
		int ans[]=new int[q.length];
		int sum=Arrays.stream(n).sum();
		Arrays.sort(n);
		//System.out.println(sum);
		for (int i = 0; i < ans.length; i++) {
			int c=0;
			int sm=sum;
			//System.out.println(sm);
			int j=n.length-1;
			while(q[i]<sm && j>=0) {
				sm-=n[j];
				j--;
				c++;
			}
			ans[i]=n.length-c;
		}
		return ans;
	}
}