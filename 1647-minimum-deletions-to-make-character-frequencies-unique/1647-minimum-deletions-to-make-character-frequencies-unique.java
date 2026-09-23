class Solution {
    public int minDeletions(String s) {
      HashMap<Character,Integer> result = new HashMap<>();

        for(char ch:s.toCharArray()){
            result.put(ch, result.getOrDefault(ch, 0) + 1);
        }

        int deletion = 0;
        HashSet<Integer> used = new HashSet<>();

        for (int freq : result.values()) {
            while (freq > 0 && used.contains(freq)) {
                freq--;
                deletion++;
            }
            
            used.add(freq);
        }
        return deletion;
    }
}