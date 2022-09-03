class Solution {
    public int totalFruit(int[] fruits) {
        return maxFruits(fruits);
    }
    private static int maxFruits(int[] arr) {
		// TODO Auto-generated method stub
		int ei=0,si=0;
		int count=0;
		int ws=Integer.MIN_VALUE;
		int []frq=new int[100000];
		while(ei<arr.length) {
			int f=arr[ei];
			if(frq[f]==0) {
				count++;
			}
			frq[f]++;
			
			while(count>2 && si<=ei) {
				int r=arr[si];
				frq[r]--;
				if(frq[r]==0) {
					count--;
				}
				si++;
			}
			
				if(ws<ei-si+1) {
					ws=ei-si+1;
				}
			
			ei++;
		}
		return ws;
	}
}