class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

       
        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll(); // remove least frequent
            }
        }

        // Step 4: Build result
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;
    }
}
