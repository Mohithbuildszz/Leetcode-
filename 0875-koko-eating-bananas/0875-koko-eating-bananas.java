class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = maxx(piles);
        while(low <= high){
            int mid = (low + high) / 2;
            if(totalSum(piles,mid) <= h){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    } 
    private int maxx(int[] piles){
        int n = piles.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi  = Math.max(piles[i], maxi);
        }
        return maxi;
    } private int totalSum(int[] piles, int d){
        int n = piles.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total += Math.ceil((double)piles[i] / d);
        }
        return total;
    }
}