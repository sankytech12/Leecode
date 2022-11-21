class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        int n1=nums1.length,n2=nums2.length;
        int lo=0,hi=n1;
        while(lo<=hi){
            int cut1=(lo+hi)>>1;
            int cut2=(n1+n2+1)/2-cut1;
            int l1=cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
            int l2=cut2==0?Integer.MIN_VALUE:nums2[cut2-1];
            int r1=cut1==n1?Integer.MAX_VALUE:nums1[cut1];
            int r2=cut2==n2?Integer.MAX_VALUE:nums2[cut2];
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1>r2){
                hi=cut1-1;
            }else{
                lo=cut1+1;
            }
        }
        return 0.0;
    }
}