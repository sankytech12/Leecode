class Solution {
    public int maximumSum(int[] arr) {
        int n=arr.length;
        int high=Integer.MIN_VALUE;
        for (int i : arr) {
            high=Math.max(i, high);
        }
        if(high<0) return high;
        int []forward=new int[n];
        int currMax=0;
        for (int i = 0; i < forward.length; i++) {
            currMax=Math.max(currMax+arr[i], arr[i]);
            forward[i]=currMax;
        }
        int []backward=new int[n];
        currMax=0;
        int bestMax=0;
        for(int i=n-1;i>=0;i--){
            currMax=Math.max(currMax+arr[i], arr[i]);
            bestMax=Math.max(currMax, bestMax);
            backward[i]=currMax;
        }
        int ans=bestMax;
        for(int i=1;i<n-1;i++){
            ans=Math.max(ans, forward[i-1]+backward[i+1]);
        }
        return ans;
    }
}