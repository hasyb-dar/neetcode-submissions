/* class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        int left = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += nums[right];

            // shrink window
            while (sum >= target) {

                int len = right - left + 1;

                minLen = Math.min(minLen, len);

                sum -= nums[left];

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
 */

class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        // Prefix sum array
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int required = prefix[i] + target;

            // Find first index where prefix[index] >= required
            int bound = lowerBound(prefix, required);

            if (bound != -1) {

                int len = bound - i;

                minLen = Math.min(minLen, len);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // Binary Search
    private int lowerBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }
}