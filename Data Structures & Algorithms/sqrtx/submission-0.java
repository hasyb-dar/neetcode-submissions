class Solution {
    public int mySqrt(int x) {
        int i = 1;
        int j = x;

        while (i <= j) {
            int a = i + (j - i) / 2;

            long square = (long) a * a;

            if (square == x) {
                return a;
            } 
            else if (square > x) {
                j = a - 1;
            } 
            else {
                i = a + 1;
            }
        }

        return j;
    }
}