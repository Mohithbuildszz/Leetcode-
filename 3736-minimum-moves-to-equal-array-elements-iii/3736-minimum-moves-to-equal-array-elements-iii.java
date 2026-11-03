class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int count = 0;
        int maxi = maxiii(nums);
        for(int i=0;i<n;i++){
            count += maxi - nums[i];
        } 
        return count;
    } private int maxiii(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(nums[i],max);
        }
        return max;
    }
}