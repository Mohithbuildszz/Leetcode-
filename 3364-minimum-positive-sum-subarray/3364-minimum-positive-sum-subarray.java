class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums.get(j);
                int length = j - i + 1;
                if(length >= l && length <= r){
                    if(sum > 0){
                        mini = Math.min(mini,sum);
                    }
                }
            }
        }
            if(mini == Integer.MAX_VALUE){
                return -1;
            }
        return mini;
    }
}