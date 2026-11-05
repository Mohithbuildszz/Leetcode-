class Solution {
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = maxii(arr);
        int ans = 0;
       long diff = Long.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low) / 2;
                int count = 0;
                for(int i=0;i<n;i++){
                    if(arr[i] > mid){
                        count += mid;
                    } else {
                        count += arr[i];
                    }
                }
         long currentDiff = Math.abs(count - target);
            if(currentDiff < diff || (currentDiff == diff && mid < ans)){
                    diff = currentDiff;
                    ans = mid;
        }
                if(count == target){
                    return mid;
                } else if(count > target){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
        }
    return ans;
    } private int maxii(int[] arr){
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i=0;i<n;i++){
            maxi = Math.max(arr[i], maxi);
        }
        return maxi;
    }
}