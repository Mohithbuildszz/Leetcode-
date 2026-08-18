class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = n * (n+1) / 2; // formula for the missing number
        int sum2 =0; // to store the total of nums
        for(int num:nums){  // to add the total into sum2
            sum2 += num;
        } 
        int missing = sum1 - sum2; //sub sum1-sum2 you gett 
        return missing;
    }
}