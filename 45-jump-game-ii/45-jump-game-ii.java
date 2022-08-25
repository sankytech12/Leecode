class Solution {
    public int jump(int[] nums) {
       // return minS(nums);
        return minStep(nums,nums.length);
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
    
	private static int  minStep(int[] arr,int n) {
		// TODO Auto-generated method stub
		if(n==1) {
			return 0;
		}
		else if(arr[0]==0) {
			return -1;
		}
		else {
			int step=arr[0];
			int maxR=arr[0];
			int jump=1;
			for (int i = 1; i < arr.length; i++) {
				if(i==n-1) {
					return jump;
				}
				maxR=Math.max(maxR, i+arr[i]);
				step--;
				if(step==0) {
					jump++;
					if(i>=maxR) {
						return -1;
					}
					step=maxR-i;
					
				}
			}
			return -1;
		}
	}
}