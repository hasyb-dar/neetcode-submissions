class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int lo = 1;
        int hi = max;
        int ans = max;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (numOfhours(piles, mid) <= h) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    long numOfhours(int[] piles, int k) {
        long hours = 0;

        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) {
                hours += 1;
            }
        }

        return hours;
    }
}
