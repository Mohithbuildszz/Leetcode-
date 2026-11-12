class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int max = 1;
        int increase = 1;
        int decrease = 1;
        int DecreaseMaxi = 1;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]){
                increase++;
                  decrease = 1;
            } else if(nums[i] < nums[i-1]){
                decrease++;
               increase = 1;
            } else {
                increase = 1;
                decrease = 1;
            } 
             DecreaseMaxi = Math.max(increase,decrease);
            max = Math.max(DecreaseMaxi,max);
        }
        return max;
    }
}