class Solution {

    public int timetaken(int[] weights, int capacity) {
        int days = 1;
        int currentWeight = 0;

        for (int weight : weights) {

            if (currentWeight + weight > capacity) {
                days++;
                currentWeight = 0;
            }

            currentWeight += weight;
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int maxWeight = 0;
        int totalWeight = 0;

        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        int i = maxWeight;
        int j = totalWeight;

        while (i <= j) {

            int mid = i + (j - i) / 2;

            int requiredDays = timetaken(weights, mid);

            if (requiredDays <= days) {
                // Capacity works, try smaller
                j = mid - 1;
            } 
            else {
                // Capacity is too small, increase it
                i = mid + 1;
            }
        }

        return i;
    }
}