class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int count = 1;
        int max = 1;
        for(int i=0;i<n-1;i++){
            if(nums[i] >= nums[i+1]){
                count=1;
            } else if(nums[i] < nums[i+1]){
                count++;
            }else{
                count = 1;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}