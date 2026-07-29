class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxLen = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // track the most frequent character in window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // if window is invalid → shrink from left
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}