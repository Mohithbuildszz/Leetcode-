class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        long low = max(nums);
        long high = sum(nums);
        long ans = high;
        while(low <= high){
            long mid = low + (high-low) / 2;
                int count = 1;
                long current = 0;
                for(int i=0;i<n;i++){
                    if(current + nums[i] > mid){
                        count = count + 1;
                        current = nums[i];
                    } else {
                        current += nums[i];
                    }
                }
                if(count <= k){
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
        }
        return (int) ans;
    } private int max(int[] nums){
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi,nums[i]);
        }
        return maxi;
    } private long sum(int nums[]){
        int n = nums.length;
        long totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        return totalSum;
    }
}