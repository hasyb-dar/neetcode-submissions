class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pp = new int[n];
        pp[0] = nums[0];
        int[] sp = new int[n];
        sp[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            pp[i] = pp[i-1]*nums[i];
        }
        for(int i=n-2; i>=0; i--){
            sp[i] = sp[i+1]*nums[i];
        }
        int[] result = new int[n];
        result[0] = sp[1];
        result[n-1] = pp[n-2];
        for(int i=1; i<n-1; i++){
            result[i] = sp[i+1]*pp[i-1];
        }
        return result;
    }
}  
