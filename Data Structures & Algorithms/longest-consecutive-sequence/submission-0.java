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
            int l = 1;
            int c = num;
            while(set.contains(c + 1)) {
                l++;
                c++;
            }
            maxLen = Math.max(l,maxLen);
        }
        return maxLen;
    }
}
