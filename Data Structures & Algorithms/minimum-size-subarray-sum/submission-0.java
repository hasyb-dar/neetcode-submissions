class Solution {

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