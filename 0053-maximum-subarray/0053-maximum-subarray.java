class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int i = nums[0];
        int maxanswer = nums[0];
        for(int j=1;j<n;j++){
            i = Math.max(nums[j], i+nums[j]);
            maxanswer = Math.max(i,maxanswer);
        }
        return maxanswer;
    }
}