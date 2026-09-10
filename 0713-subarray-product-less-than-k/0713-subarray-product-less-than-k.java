class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left =0;
        int count = 0;
        long sum = 1;
        for(int i=0;i<n;i++){
            sum *= nums[i];
            while(sum>=k && left <= i){
                sum /= nums[left];
                left++;
            }
            count += i-left+1;
        }
        return count;
    }
}