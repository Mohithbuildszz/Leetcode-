class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int count = n / 3;
        List<Integer> keys = new ArrayList<>(map.keySet());
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<keys.size();i++){
            int key = keys.get(i);
            if(map.get(key) > count){
                result.add(key);
            }
        }
       return result; 
    }
}