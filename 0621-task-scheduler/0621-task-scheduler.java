class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequence = new int[26];
        for (char task:tasks) {
            frequence[task-'A']++;
        }
        int maxfrequency = 0;
        for (int i = 0; i < 26; i++) {
            maxfrequency = Math.max(maxfrequency, frequence[i]);
        }
        int maxcount = 0;
        for (int i = 0; i < 26; i++) {
            if (frequence[i] == maxfrequency) {
                maxcount++;
            }
        }
    int result = (maxfrequency - 1) * (n + 1) + maxcount;
    return Math.max(tasks.length, result);  
    }
}