class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closest = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int total = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(total - target);
                    if(diff<closest){
                        closest=diff;
                        ans=total;
                    }
                }
            }
        }
        return ans;
    }
}