class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        return maxUnit(boxTypes,truckSize);
    }
private static int maxUnit(int[][] boxes, int truckSize) {
		// TODO Auto-generated method stub
		Arrays.sort(boxes,(a,b) -> -Integer.compare(a[1],b[1]));
		int units=0;
		for(int []box:boxes) {
			if(truckSize<box[0]) {
				return units+truckSize*box[1];
			}
		units+=box[0]*box[1];
		truckSize-=box[0];
		}
		return units;
	}
}