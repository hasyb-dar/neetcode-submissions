class Solution {
    public int largestRectangleArea(int[] A) {
        int n = A.length;
        int ps[] = new int[n];
        int ns[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.empty() && A[st.peek()]>=A[i]){
                st.pop();
            }
            if(!st.empty()){
                ps[i] = st.peek();
            }
            else{
                ps[i] = -1;
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.empty() && A[st.peek()]>=A[i]){
                st.pop();
            }
            if(!st.empty()){
                ns[i] = st.peek();
            }
            else{
                ns[i] = n;
            }
            st.push(i);
        }
        int area = 0;
        for(int center=0; center<n; center++){
            area = Math.max(area, A[center] * (ns[center] - ps[center] - 1));
        }
        return area;
    }
}
