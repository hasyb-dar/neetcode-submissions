/* class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int l = 0;
        int r = 0;

        int[] arr = new int[m + n];
        int k = 0;

        while (l < m && r < n) {

            if (nums1[l] <= nums2[r]) {
                arr[k++] = nums1[l];
                l++;
            } 
            else {
                arr[k++] = nums2[r];
                r++;
            }
        }

        while (l < m) {
            arr[k++] = nums1[l];
            l++;
        }

        while (r < n) {
            arr[k++] = nums2[r];
            r++;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = arr[i];
        }
    }
} */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int l = m - 1;
        int r = n - 1;
        int k = m + n - 1;

        while (l >= 0 && r >= 0) {

            if (nums1[l] > nums2[r]) {
                nums1[k] = nums1[l];
                l--;
            } 
            else {
                nums1[k] = nums2[r];
                r--;
            }

            k--;
        }

        while (r >= 0) {
            nums1[k] = nums2[r];
            r--;
            k--;
        }
    }
}