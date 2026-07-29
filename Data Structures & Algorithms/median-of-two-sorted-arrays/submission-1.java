class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if (A.length > B.length) {
            int [] temp = A;
            A = B;
            B = temp;
        }

        int m = A.length;
        int n = B.length;
        int mid1 = 0;
        int mid2 = 0;
        int l = 0;
        int h  = m;
        while(l<=h){
            int n1 = (l+h)/2;
            int n2 = (n+m)/2 -n1;
            int last_A_left = n1-1;
            int last_B_left = n2-1;
            int first_A_right = last_A_left + 1;
            int first_B_right = last_B_left + 1;
            if(last_A_left!=-1 && first_B_right!=n && A[last_A_left] > B[first_B_right]){
                h = n1-1;
            }
            else if(last_B_left!=-1 && first_A_right!=m && B[last_B_left]>A[first_A_right]){
                l = n1 + 1;
            }
            else{
                mid1 = n1 -1;
                mid2 = n2 - 1;
                break;
            }
        }
        /* System.out.print(mid1+" "+mid2+" "); */
        int maxLeft = -1000000001;
        if(mid1>=0){
            maxLeft = Math.max(maxLeft, A[mid1]);
        }
        if(mid2>=0){
            maxLeft = Math.max(maxLeft, B[mid2]);
        }
        int minRight = 1000000001;
        if(mid1<m-1){
            minRight = Math.min(minRight, A[mid1+1]);
        }
        if(mid2<n-1){
            minRight = Math.min(minRight, B[mid2+1]);
        }

        if((m+n)%2==0){
            return (double)(maxLeft+minRight)/2;
        }
        else{
            return minRight;
        }
    }
}
