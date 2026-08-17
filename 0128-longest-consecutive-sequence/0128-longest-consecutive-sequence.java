class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (nums.length == 0) {
         return 0;
}
        Arrays.sort(nums);
        int current= 1;
        int max = 1;
        for(int i=1;i<n;i++){
                if(nums[i] == nums[i-1] +1){
                        current++;
                       max =  Math.max(max, current);
                } else if(nums[i] == nums[i-1]){
                        
                }else {
                        current=1;
                }
        }
        return max;
    }
}