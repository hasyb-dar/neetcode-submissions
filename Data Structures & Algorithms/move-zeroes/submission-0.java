class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l=0;
        int r = 0;
        while(r<n){
            if(nums[r]!=0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r++;
                l++;
            }
            else{
                r++;
            }
        }

    }
}