class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> result = new HashMap<>();
       for(int i=0;i<n;i++){
        result.put(nums[i], result.getOrDefault(nums[i],0)+1);
       }
       ArrayList<Map.Entry<Integer,Integer>> Ans = new ArrayList<>(result.entrySet());
       Ans.sort((a,b)->b.getValue()-a.getValue());
       int[] Arr = new int[k];
       for(int i=0;i<k;i++){
        Arr[i] = Ans.get(i).getKey();
       }
        return Arr;
    }
}