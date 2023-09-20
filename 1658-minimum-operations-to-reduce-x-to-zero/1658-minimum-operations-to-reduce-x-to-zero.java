class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=Arrays.stream(nums).sum();
        int target=sum-x;
        if(target<0) return -1;
        if(target==0) return nums.length;
        int n=nums.length;
        int curr=0;
        int ans=Integer.MAX_VALUE;
        int si=0,ei=0;
        while(ei<n){
            curr+=nums[ei];
            while(curr>target && si<n){
                curr-=nums[si++];
            }
            if(curr==target) ans=Math.min(ans,n-(ei-si+1));
            ei++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}

/* 
        int totalSum = Arrays.stream(nums).sum();
        int target = totalSum - targetSum; // Calculate the target sum difference

        if (target < 0)
            return -1; // Return -1 if target sum is not achievable

        if (target == 0)
            return nums.length; // Return the number of elements if target sum is 0

        int n = nums.length; // Number of elements in the array
        int minOperations = Integer.MAX_VALUE; // Minimum operations to achieve the target sum
        int currentSum = 0; // Current sum of elements
        int leftIndex = 0, rightIndex = 0; // Pointers for the sliding window

        while (rightIndex < n) {
            currentSum += nums[rightIndex];
            rightIndex++;

            while (currentSum > target && leftIndex < n) {
                currentSum -= nums[leftIndex];
                leftIndex++;
            }

            if (currentSum == target)
                minOperations = Math.min(minOperations, n - (rightIndex - leftIndex));
        }

        return (minOperations == Integer.MAX_VALUE) ? -1 : minOperations; // 

*/