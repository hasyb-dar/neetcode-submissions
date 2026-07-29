/* class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n-k+1];
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        result[0] = nums[dq.peekFirst()];
        int a = 1;
        for(int i=k; i<n; i++){
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            result[a++] = nums[dq.peekFirst()];
        }
        return result;
    }
} */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];

            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }

            result[i] = max;
        }

        return result;
    }
}
