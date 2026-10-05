class Solution {
    public int pivotIndex(int[] nums) {
        
        int n = nums.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
        }

        int leftsum = 0;
        for(int i=0;i<n;i++){
            int rightSum = total - leftsum - nums[i];
            if(leftsum == rightSum){
                return i;
            } 
            leftsum += nums[i];
        }
        return -1;
    }
}