class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i=0;i<n;i++){
           total += nums[i];
        } 
        int leftsum = 0;
        for(int i=0;i<n;i++){
            int rightsum = total - leftsum - nums[i];
    if (leftsum == rightsum) {
        return i;
            } else{
                leftsum += nums[i];
            }
        }
        return -1;
    }
}