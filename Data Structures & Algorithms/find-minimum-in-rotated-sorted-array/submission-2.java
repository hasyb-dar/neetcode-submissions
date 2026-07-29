class Solution {
    public int findMin(int[] A) {
        int n = A.length;
        int l = 0, h = n-1;
        int last = -1;
        if (A[l] <= A[h]) return A[0];
        while(l<=h){
            int mid = l + (h-l)/2;
            if(A[mid] >= A[0]){
                
                l = mid + 1;
            }
            else{
                //last = mid;
                h = mid - 1;
            }
        }
        return A[l];
    }
}
