
class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq[b] - freq[a]);
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                pq.offer((char)i);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            for (int j = 0; j < freq[ch]; j++) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
