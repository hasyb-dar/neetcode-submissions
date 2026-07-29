class Solution {
    public int trap(int[] A) {
        int n = A.length;
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
        return water;
    }
}
