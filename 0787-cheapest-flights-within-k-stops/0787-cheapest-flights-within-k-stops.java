import java.util.*;

class Solution {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        // Create adjacency list
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // from -> {to, price}
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph[from].add(new int[]{to, price});
        }

        // Queue stores:
        // {current city, total price, number of stops}
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{src, 0, 0});

        int[] minPrice = new int[n];

        Arrays.fill(minPrice, Integer.MAX_VALUE);

        minPrice[src] = 0;

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int city = current[0];
            int price = current[1];
            int stops = current[2];

            // If destination reached
            if (city == dst) {
                answer = Math.min(answer, price);
                continue;
            }

            // We can take at most k stops
            if (stops > k) {
                continue;
            }

            // Visit neighboring cities
            for (int[] next : graph[city]) {

                int nextCity = next[0];
                int flightPrice = next[1];

                int newPrice = price + flightPrice;

                // Only continue if this route is cheaper
                if (newPrice < minPrice[nextCity]) {

                    minPrice[nextCity] = newPrice;

                    queue.offer(
                        new int[]{
                            nextCity,
                            newPrice,
                            stops + 1
                        }
                    );
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}