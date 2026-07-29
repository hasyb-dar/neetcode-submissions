class Solution {
    public int trap(int[] A) {
        /* int n = A.length;
        int l = 0;
        int r = n-1;
        int lm = 0;
        int rm = 0;
        int water = 0;
        while(l<r){
            if(A[l]<=A[r]){
                if(lm<A[l]){
                    lm = A[l];
                }
                else{
                    water += lm -A[l];
                }
                l++;
            }
            else{
                if(A[r]>rm){
                    rm = A[r];
                }
                else{
                    water += rm -A[r];
                }
                r--;
            }
        }
        return water; */

        int n = A.length;
        int[] P = new int[n];
        int[] Q = new int[n];
        int sum = 0;
        P[0] = A[0];
        for(int i=1; i<n; i++){
            P[i] = Math.max(P[i-1],A[i]);
        }
         Q[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            Q[i] = Math.max(Q[i + 1], A[i]);
        }
        for(int i=0; i<n; i++){
            sum = sum + Math.min(P[i],Q[i]) - A[i];
        }
        return sum;
    }
}


