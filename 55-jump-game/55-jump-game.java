class Solution {
    public boolean canJump(int[] arr) {
        
      return minStep(arr,arr.length)>=0?true:false;
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