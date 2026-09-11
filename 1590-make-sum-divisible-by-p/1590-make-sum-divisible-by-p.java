class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long total = 0;
        for(int i=0;i<n;i++){
           total += nums[i];
        } 
         int rem = (int) (total % p);
        if(rem == 0){
            return 0;
        }
        HashMap<Integer,Integer> mini = new HashMap<>();
        mini.put(0,-1);
        int result = nums.length;
        int minilength= Integer.MAX_VALUE;
        long prefixSum = 0; 
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            int currentRem = (int) (prefixSum % p);
            int needed = (currentRem - rem +p)%p;
            if(mini.containsKey(needed)){
                int length = i - mini.get(needed);
                minilength = Math.min(minilength, length);
            }
            mini.put(currentRem,i);
        }
return minilength == nums.length ? -1 : minilength;
    }
}