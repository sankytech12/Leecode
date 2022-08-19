class Solution {
    public int rob(int[] arr) {
        if(arr.length==1){
            return arr[0];
        }
        if(arr.length==2){
            return Math.max(arr[0],arr[1]);
        }
        int first=maxRobbed(arr, 0, arr.length-1);
		int sec=maxRobbed(arr, 1, arr.length);
		return Math.max(first, sec);
    }
   private static int maxRobbed(int[] arr,int i,int end) {
		// TODO Auto-generated method stub
		int preTwo=0;
		int preOne=0;
		int max=0;
		for (int j = i; j <end; j++) {
			max=Math.max(preTwo+arr[j],preOne);
			preTwo=preOne;
			preOne=max;
		}
		return max;
	}

}