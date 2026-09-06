class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;

        // Step 1: Place each number in its correct position if possible
        for (int i = 0; i < n; i++) {
            while (A[i] > 0 && A[i] <= n && A[i] != A[A[i] - 1]) {
                // Swap A[i] with A[A[i] - 1]
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }

        // Step 2: Find the first index where A[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        // All positions are correct
        return n + 1;
    }
}