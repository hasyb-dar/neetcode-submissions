class Solution {
    public int longestConsecutive(int[] nums) {
        /* if (nums.length == 0) return 0;
        
        Arrays.sort(nums);
        
        int maxLen = 1;
        int currLen = 1;
        
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i] == nums[i - 1]) {
                continue; // skip duplicates
            }
            
            if (nums[i] - nums[i - 1] == 1) {
                currLen++;
            } else {
                currLen = 1;
            }
            
            maxLen = Math.max(maxLen, currLen);
        }
        
        return maxLen; */

        Set<Integer> set = new HashSet<>();
        
        // Step 1: add all elements
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLen = 0;
        for (int num : set) {
            
            // only start if it's the beginning
            if (!set.contains(num - 1)) {
                
                int current = num;
                int length = 1;
                
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                
                maxLen = Math.max(maxLen, length);
            }
        }
        return maxLen;
    }
}
