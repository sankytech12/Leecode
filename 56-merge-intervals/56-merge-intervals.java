class Solution {
    public int[][] merge(int[][] intervals) {
        return solve(intervals);
    }
    private static int[][] solve(int[][] arr) {
		// TODO Auto-generated method stub
		List<int []> res=new ArrayList<>();
		if(arr.length==0 || arr==null) {
			return res.toArray(new int[0][]);
		}
		Arrays.sort(arr,(a,b) -> a[0]-b[0]);
		int start=arr[0][0];
		int end=arr[0][1];
		for(int []i:arr) {
			if(i[0]<=end) {
				end=Math.max(i[1], end);
			}else {
				res.add(new int []{start,end});
				start=i[0];
				end=i[1];
				
			}
		}
		res.add(new int[] {start,end});
		return res.toArray(new int[0][]);
	}
}