class Solution {
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        int ans = 0;

       HashMap<Integer,Integer> result = new HashMap<>();
       for(int i=0;i<n;i++){
        result.put(nums[i], result.getOrDefault(nums[i],0)+1);
       }

        for(int j=0;j<n;j++){
        if(result.get(nums[j]) == 1){
            ans += nums[j];
        }
       }

       return ans;
    }
}