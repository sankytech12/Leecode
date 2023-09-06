class Solution {
    public int subarraySum(int[] nums, int k) {
        return solve(nums,k);
    }
     private static int solve(int[] arr, int k) {
       int sum=0;
       int ans=0;
       HashMap<Integer,Integer> map=new HashMap<>();
       map.put(0, 1);
       for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            int diff=sum-k;
            if(map.containsKey(diff)) ans+=map.get(diff);
            map.put(sum, map.getOrDefault(sum, 0)+1);
       }
       return ans;
    }
}