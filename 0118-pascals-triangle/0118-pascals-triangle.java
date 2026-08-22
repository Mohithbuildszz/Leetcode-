class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> nums = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j == 0 || j == i){
                    nums.add(1);
                } else {
                    int valueofMiddle = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                    nums.add(valueofMiddle);
                }
            }
            ans.add(nums);
        }
        return ans;
    }
}