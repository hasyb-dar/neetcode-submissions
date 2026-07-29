class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int [] result = new int[2];
        int l = 0;
        int r = n-1;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                result[0] = l+1;
                result[1] = r+1;
                return result;
            }
            else if(numbers[l] + numbers[r] > target){
                r--;
            }
            else{
                l++;
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }
}
