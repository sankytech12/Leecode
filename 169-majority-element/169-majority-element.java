class Solution {
    public int majorityElement(int[] arr) {
		// int max=0;
		// for (int i = 0; i < arr.length; i++) {
		// 	max=Math.max(max, arr[i]);
		// }
		// int frq[]=new int[max];
		// for (int i = 0; i < arr.length; i++) {
		// 	int j=arr[i];
		// 	frq[j-1]++;
		// }
		// int ans=0;
		// for (int i = 0; i < frq.length; i++) {
		// 	if(frq[i]>arr.length/2) {
		// 		ans=i+1;
		// 	}
		// }
		// return ans;
        return solve(arr);
    }
    public int solve(int []arr){
        int ele=0;
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                c++;
            }
            else if(c==0) {
                ele=arr[i];
                c=1;
            }
            else c--;
        }
        return ele;
    }
}