class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int n = nums.length;
        int left = 0;
        int count = 0;
        int ans = Integer.MAX_VALUE;
        for(int right = 0; right<n; right++){
            count += nums[right];
            while(count >= target){
                int len = right - left + 1;
                ans = Math.min(ans, len);
                count -= nums[left];
                left++;
            } 
        }  
        return ans != Integer.MAX_VALUE ?  ans : 0; 
    }
}