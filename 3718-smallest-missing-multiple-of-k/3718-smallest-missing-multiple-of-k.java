class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> result = new HashSet<>();
        for(int num:nums){
            result.add(num);
        }
        int multiple = k;
        while(result.contains(multiple)){
            multiple += k;
        }
        return multiple;
    }
}