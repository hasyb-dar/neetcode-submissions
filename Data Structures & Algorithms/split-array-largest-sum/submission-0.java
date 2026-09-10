class Solution {
    public int splitArray(int[] nums, int k) {
       int n = nums.length;
       int sum = 0;
       int max = 0;
       for(int i=0; i<n;i++){
        max = Math.max(nums[i],max);
        sum += nums[i];
       }
       int ans = 0;
       int l = max;
       int h = sum;

       while(l<=h){
        int mid = (l+h)/2;
        if(findsumofk(nums,mid) <=k ){
            ans = mid;
            h = mid-1;
        }
        else{
            l = mid +1;
        }
       }
       return ans;
    }

    private int findsumofk(int[] nums,int mid){
        int count = 1;
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {

            if(sum + nums[i] > mid) {
                count++;
                sum = nums[i];
            }
            else {
                sum += nums[i];
            }
        }

        return count;
    }
}