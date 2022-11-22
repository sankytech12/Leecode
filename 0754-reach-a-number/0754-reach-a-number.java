class Solution {
    public int reachNumber(int target) {
        int sum=0;
        int step=0;
        target=Math.abs(target);
        while(sum<target){
            step++;
            sum+=step;
        }
        while(Math.abs(sum-target)%2!=0){
            step++;
            sum+=step;
        }
        return step;
    }
}