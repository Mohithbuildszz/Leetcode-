class Solution {
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        int ans = 0;
       HashMap<Integer,Integer> result = new HashMap<>();
       for(int i=0;i<n;i++){
        if(result.containsKey(nums[i])){
            result.put(nums[i],result.get(nums[i]) + 1);
        } else {
            result.put(nums[i], 1);
        }
       }
        for(int j=0;j<n;j++){
        if(result.get(nums[j]) == 1){
            ans += nums[j];
        }
       }
       return ans;
    }
}