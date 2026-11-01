class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int mini = minimum(nums);
        int count = 0;
        for(int i=0;i<n;i++){
            count += nums[i] - mini;
        }
    return count;
    }
         private int minimum(int[] nums){
            int n = nums.length;
            int mini = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                mini = Math.min(nums[i],mini);
            }
            return mini;
        }
}