class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        HashSet <Integer> ans = new HashSet<>(); 
        for(int right=0; right<n; right++){
            if(ans.contains(nums[right])){
                return true;
                }
                ans.add(nums[right]);
                if(right-left >= k ){
                     ans.remove(nums[left]);
                     left++;
                }
            }
            return false;
        }
    }