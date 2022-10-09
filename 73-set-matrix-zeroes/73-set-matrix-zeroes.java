class Solution {
    public void setZeroes(int[][] matrix) {
        set(matrix);
    }
   private static void set(int[][] arr) {
		// TODO Auto-generated method stub
		//int [][]vis=new int[arr.length][arr[0].length];
       boolean f=false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j]==0) {
					setZero(arr,i,j);
                    f=true;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j]==-1 && f) {
					arr[i][j]=0;
				}
			}
		}
	}

	private static void setZero(int[][] arr, int i, int j) {
		// TODO Auto-generated method stub
		for (int k = 0; k < arr.length; k++) {
			if(arr[k][j]!=0) arr[k][j]=-1;
			
			
		}
		for (int j2 = 0; j2 < arr[0].length; j2++) {
			if(arr[i][j2]!=0) arr[i][j2]=-1;
			
		}
		
	}


}