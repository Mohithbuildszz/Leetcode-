class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int maxEnding = nums[0];
        int maxSoFar = nums[0];
        int minEnding = nums[0];
        int minSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEnding);
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSoFar = Math.min(minSoFar, minEnding);
        }
        if (maxSoFar < 0) {
            return maxSoFar;
        }
        int circularSum = totalSum - minSoFar;
        return Math.max(maxSoFar, circularSum);
    }
}