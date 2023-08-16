class Solution {
    public int maxSum(int[] nums) {
        return solve(nums);
    }
    private static int solve(int[] arr) {
        //int frq2[]=new int[10];
       int ans=-1;
        for (int i = 0; i < arr.length; i++) {
            int frq1[]=new int[10];
            int num=arr[i];
            int max1=0;
            while(num>0){
                int n=num%10;
                if(n>max1) max1=n;
                frq1[n]++;
                num/=10;
            }
            for(int j=i+1;j<arr.length;j++){
                int []frq2=new int[10];
                int num2=arr[j];
                int max2=0;
                while(num2>0){
                    int n2=num2%10;
                    if(n2>max2) max2=n2;
                    frq2[n2]++;
                    num2/=10;
                }
                if(max1==max2){
                    ans=Math.max(ans, arr[i]+arr[j]);
                }
            }
        }
        
        return ans;
    }
}