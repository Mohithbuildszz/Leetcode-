class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> answer = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(answer.contains(nums[i])){
                return nums[i];
            }
            answer.add(nums[i]);
        }
        return -1;
    }
}