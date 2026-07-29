/* class Solution {
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
} */

public class Solution {
    public int largestRectangleArea(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // If current bar is smaller, process previous bars
            while (!st.isEmpty() && A[st.peek()] > A[i]) {

                int height = A[st.pop()];

                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();

                int width = right - left - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        // 🔥 Final cleanup (process remaining bars)
        while (!st.isEmpty()) {

            int height = A[st.pop()];

            int right = n;
            int left = st.isEmpty() ? -1 : st.peek();

            int width = right - left - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
