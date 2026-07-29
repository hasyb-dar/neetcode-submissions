class Solution {
    public int search(int[] A, int B) {
        int n = A.length;
        int l = 0, h = n-1;
        int last = 0;
        while(l<=h){
            int mid = (l+h)/2;
            if(A[mid] >= A[0]){
                last = mid;
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        if(B >= A[0]){
            // Target is present in the left half
            l = 0;
            h = last;
        } else{
            // Target is present in the right half
            l = last+1;
            h = n-1;
        }
        while(l<=h){
            int mid = (l+h)/2;
            if(A[mid]==B){
                return mid;
            }
            else if(A[mid]<B){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return -1;
    }
}
