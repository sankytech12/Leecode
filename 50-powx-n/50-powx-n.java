class Solution {
    public double myPow(double x, int n) {
        double ans=solve(x,n);
        if(n<0){
            return 1/ans;
        }
        return ans;
    }
    public double solve(double x,int n){
        if(n==0){
            return 1;
        }
        double ans=solve(x,n/2);
        ans=ans*ans;
        if(n%2!=0){
            ans=ans*x;
        }
        return ans;
    }
}