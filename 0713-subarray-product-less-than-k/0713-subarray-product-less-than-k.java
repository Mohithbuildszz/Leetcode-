class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int sum = 1;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum *= nums[j];
                if(sum<k){
                count++;
                } else {
                    break;
                }
            }
            sum = 1;
        }
        return count;
    }
}