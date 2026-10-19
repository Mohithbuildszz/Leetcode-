class Solution {
    public int shipWithinDays(int[] weights, int days){

    int low = max(weights);
    int high = sum(weights);
    int ans = high;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        int requiredDays = calculateDays(weights, mid);
        if (requiredDays <= days) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
        } private int max(int[] weights){
            int n = weights.length;
            int maxi = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                maxi = Math.max(maxi,weights[i]);
            }
            return maxi; 
        }
        private int sum(int[] weights){
            int n = weights.length;
            int total = 0;
            for(int i=0;i<n;i++){
                total += weights[i];
            }
            return total;
        } private int calculateDays(int weights[],int capacity){
            int n = weights.length;
            int required = 1;
            int currentload = 0;
            for(int i=0;i<n;i++){
                if(currentload + weights[i] > capacity){
                    required++;
                    currentload = weights[i];
                } else {
                   currentload = currentload + weights[i];
                }
            }
            return required;
        }
}