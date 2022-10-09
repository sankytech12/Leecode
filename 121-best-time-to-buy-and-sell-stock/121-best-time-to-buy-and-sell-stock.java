class Solution {
    public int maxProfit(int[] prices) {
        // int mini=prices[0];
        // int max=0;
        // for(int i=1;i<prices.length;i++){
        //     int cost=prices[i]-mini;
        //     max=Math.max(max,cost);
        //     mini=Math.min(prices[i],mini);
        // }
        int maxP=0;
        int minPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice,prices[i]);
            maxP=Math.max(maxP,prices[i]-minPrice);
        }
        return maxP;
    }
}