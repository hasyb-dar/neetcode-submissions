public class Solution {
    public int findDuplicate(int[] nums) {

        // n = max possible value in array
        int n = nums.length - 1;

        int low = 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // STEP 1: count how many numbers are <= mid
            int count = 0;

            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // STEP 2: decision making
            // If count > mid → duplicate lies in [1..mid]
            if (count > mid) {
                high = mid;
            }
            // else duplicate lies in [mid+1..n]
            else {
                low = mid + 1;
            }
        }

        // low == high → duplicate number
        return low;
    }
}