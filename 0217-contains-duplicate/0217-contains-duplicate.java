class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap <Integer,Integer> abc = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            if(abc.containsKey( (int) nums[i])){
            return true;
            } else {
                int count = 1;
                abc.put(nums[i], count);
            }
        }
        return false;
    }
}