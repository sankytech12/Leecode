class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        ans[0]=0;
        for(int i=1;i<n+1;i++){
            ans[i]=solve(i);
        }
        return ans;
    }
    public int solve(int n){
        int count=0;
        while(n!=0){
            count++;
            n=(n&(n-1));
        }
        return count;
    }
}