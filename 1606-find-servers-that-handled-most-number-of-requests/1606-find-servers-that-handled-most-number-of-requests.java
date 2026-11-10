
import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        // Stores available server IDs
        TreeSet<Integer> available = new TreeSet<>();

        // Stores busy servers: {finishTime, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Counts requests handled by each server
        int[] count = new int[k];

        // Initially, all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Process each request
        for (int i = 0; i < arrival.length; i++) {

            // Release servers whose requests have completed
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i]) {

                int[] completed = busy.poll();
                available.add(completed[1]);
            }

            // Preferred server
            int preferred = i % k;

            // Find next available server
            Integer server = available.ceiling(preferred);

            // Wrap around if necessary
            if (server == null && !available.isEmpty()) {
                server = available.first();
            }

            // All servers are busy
            if (server == null) {
                continue;
            }

            // Assign request to the selected server
            available.remove(server);

            // Update request count
            count[server]++;

            // Calculate completion time and mark server busy
            int finishTime = arrival[i] + load[i];

            busy.offer(new int[]{finishTime, server});
        }

        // Find maximum number of requests handled
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Collect all busiest server IDs
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
