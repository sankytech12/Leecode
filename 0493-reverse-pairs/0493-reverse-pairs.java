class Solution {
    public int reversePairs(int[] arr) {
        int []temp=new int[arr.length];
        int ans=solve(arr,temp,0,arr.length-1);
        return ans;
    }

    private static int solve(int[] arr,int []temp,int lo,int hi) {
        if(lo>=hi) return 0;
        int mid=(lo+hi)>>1;
        int count=0;
        count+=solve(arr,temp, lo, mid);
        count+=solve(arr,temp, mid+1, hi);
        count+=merge(arr,temp,lo,mid,hi);
        return count;
    }

    private static int merge(int[] arr, int[] temp,int lo, int mid, int hi) {
        //int i=lo;
        int j=mid+1;
        int count=0;
        for(int i=lo;i<=mid;i++){
            while(j<=hi && arr[i]>2*(long)(arr[j])){
                j++;
            }
            count+=(j-(mid+1));
        }
        int k=lo;
        int i=lo;
        j=mid+1;
        while(i<=mid && j<=hi){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=hi){
            temp[k++]=arr[j++];
        }
        for (int l = lo; l <= hi; l++) {
            arr[l]=temp[l];
        }
        return count;
    }

}