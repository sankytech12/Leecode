class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean visited[]=new boolean[arr.length];
		
		return isPossible(arr,start,visited);
    }
    private static boolean isPossible(int[] arr, int i, boolean[] visited) {
		// TODO Auto-generated method stub
		if(i<0||i>=arr.length) {
			return false;
		}
		if(arr[i]==0) {
			return true;
		}
		if(visited[i]==true) {
			return false;
		}
		visited[i]=true;
		boolean one=isPossible(arr, i+arr[i], visited);
		boolean two=isPossible(arr, i-arr[i], visited);
		
		
		return one||two;
	}
}