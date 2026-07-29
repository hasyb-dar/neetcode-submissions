class Solution {
    public int[] dailyTemperatures(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.empty() && A[st.peek()]<=A[i]){
                st.pop();
            }
            if(!st.empty()){
                result[i] = st.peek()-i;
            }
            else{
                result[i] = 0;
            }
            st.push(i);
        }
        return result;
    }
}
