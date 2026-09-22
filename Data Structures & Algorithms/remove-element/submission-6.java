class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int[]  ans = new int[n];
        int j=0;
        int k=0;
        if(n==0){
            return 0;
        }
        while(j<n){
            while(j<n && nums[j]==val){
                j++;
            }
            if(j<n && nums[k]==val && nums[j]!=val){
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k++;
            }
            else{
                k++;
                j++;
            }
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                count++;
            }
        }

        return count;
    }
}