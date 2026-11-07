
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        // Available servers: [weight, index]
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b)-> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy servers: [finishTime, weight, index]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                if (a[1] != b[1]) {
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[2], b[2]);
            }
        );

        // Initially, all servers are available
        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[m];
        long time = 0;

        for (int i = 0; i < m; i++) {

            // Task i arrives at time i
            time = Math.max(time, i);

            // Release completed servers
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] completed = busy.poll();

                available.offer(new int[]{
                    (int) completed[1],
                    (int) completed[2]
                });
            }

            // If all servers are busy, wait
            if (available.isEmpty()) {
                time = busy.peek()[0];

                // Release all servers completed by this time
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] completed = busy.poll();

                    available.offer(new int[]{
                        (int) completed[1],
                        (int) completed[2]
                    });
                }
            }

            // Select the best available server
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            ans[i] = index;

            // Calculate finishing time
            long finishTime = time + tasks[i];

            // Move server to busy heap
            busy.offer(new long[]{
                finishTime,
                weight,
                index
            });
        }

        return ans;
    }
}
