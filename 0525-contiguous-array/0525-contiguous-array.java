class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int zeros= 0;
        int ones = 0;
        HashMap<Integer,Integer> result = new HashMap<>();
        result.put(0,-1);
        int maxlen = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                sum = sum + 1;
            }else if(nums[i] == 0){
                sum = sum - 1;
            } if(result.containsKey(sum)){
            int prev = result.get(sum);
            int curr = i;
            int len = curr - prev;
            maxlen = Math.max(len,maxlen);
            } if(!result.containsKey(sum)){
                result.put(sum,i);
            }
        }
        return maxlen;
    }
}