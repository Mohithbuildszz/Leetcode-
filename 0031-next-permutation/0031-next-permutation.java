class Solution {
    public void nextPermutation(int[] nums) {
       int n = nums.length;
       //to find breaking point//
       int i = n-2;
       while(i >= 0 && nums[i] >= nums[i+1]){
        i--;
       }  
       // Swap from the smallest breaking points
       if(i>=0){
       for(int j=n-1;j>i;j--){
        if(nums[j] > nums[i]){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            break;
                }
            }
       }
       //swap the remaining elements present..
       int start = i+1;
       int end = n -1;
       while(start < end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
       }
    }
}