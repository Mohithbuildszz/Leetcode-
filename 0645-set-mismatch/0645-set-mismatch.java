class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum2=n*(n+1)/2;
        int sum1 = 0;
        for(int i=0;i<n;i++){
            sum1+=nums[i];
        }
        HashSet<Integer> result = new HashSet<>();
            int duplicate = 0;
        for(int i=0;i<n;i++){
            if(result.contains(nums[i])){
                duplicate= nums[i];
            }
            result.add(nums[i]);
        }
        int missingNo = sum2- sum1 + duplicate ;
       int[] arr = {duplicate, missingNo};
        return arr;
    }
}