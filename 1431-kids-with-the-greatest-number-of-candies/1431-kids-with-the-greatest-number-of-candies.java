class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = candies[0];
        for(int i=0;i<n;i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }
        ArrayList<Boolean> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum = candies[i] + extraCandies;
            if(sum >= max){
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}