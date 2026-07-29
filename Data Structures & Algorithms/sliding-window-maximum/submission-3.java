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


public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // Step 1: Build NGE
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }

        // Step 2: Use NGE to find max in each window
        int[] result = new int[n - k + 1];

        int j = 0; // pointer to max

        for (int i = 0; i <= n - k; i++) {

            if (j < i) {
                j = i;
            }

            // jump using nge
            while (nge[j] < i + k) {
                j = nge[j];
            }

            result[i] = nums[j];
        }

        return result;
    }
}
/* class Solution {
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
} */
