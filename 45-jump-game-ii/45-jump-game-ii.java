class Solution {
    public int jump(int[] nums) {
        return minS(nums);
    }
    private static int minS(int[] arr) {
		// TODO Auto-generated method stub
		int pos=0;
		int des=0;
		int jump=0;
		for (int i = 0; i < arr.length-1; i++) {
			des=Math.max(des, i+arr[i]);
			if(pos==i) {
				pos=des;
				jump++;
			}
		}
		return jump;
	}
}