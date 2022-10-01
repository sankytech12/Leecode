class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
       // return solve(nums,queries);
        return solve2(nums,queries);
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
    private static int[] solve2(int []n,int []q){
        Arrays.sort(n);
        for(int i=1;i<n.length;i++){
            n[i]=n[i]+n[i-1];
        }
        int res[]=new int[q.length];
        for(int i=0;i<q.length;i++){
            int j=Arrays.binarySearch(n,q[i]);
            res[i]=Math.abs(j+1);
            
        }
        return res;
    }
}