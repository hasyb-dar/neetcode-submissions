class Solution {

    void perm(int[] A, int i, int n,
              List<List<Integer>> arr) {

        // Base case
        if (i == n) {

            List<Integer> temp = new ArrayList<>();

            for (int num : A) {
                temp.add(num);
            }

            arr.add(temp);
            return;
        }

        for (int j = i; j < n; j++) {

            // Swap
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;

            // Recurse
            perm(A, i + 1, n, arr);

            // Backtrack (swap back)
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    public List<List<Integer>> permute(int[] A) {

        List<List<Integer>> arr = new ArrayList<>();

        perm(A, 0, A.length, arr);

        return arr;
    }
}