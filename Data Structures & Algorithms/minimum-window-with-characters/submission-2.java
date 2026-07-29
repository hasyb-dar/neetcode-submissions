/* class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();

        HashMap<Character, Integer> original = new HashMap<>();
        for (char ch : t.toCharArray()) {
            original.put(ch, original.getOrDefault(ch, 0) + 1);
        }

        int minlen = Integer.MAX_VALUE;
        int start = -1;

        int i = 0;
        while (i < m) {

            HashMap<Character, Integer> freq = new HashMap<>(original); // restore map
            int rl = t.length();

            int j = i;

            while (j < m && rl>0) {
                char c = s.charAt(j);

                if (freq.containsKey(c)) {
                    if (freq.get(c) > 0) {
                        freq.put(c, freq.get(c) - 1);
                        rl--;
                    }
                }

                // ✅ valid window found
                if (rl == 0) {
                    int len = j - i + 1;
                    if (len < minlen) {
                        minlen = len;
                        start = i;
                    }
                    break; // stop expanding for this i
                }

                j++;
            }

            i++;
        }

        if (start == -1) return "";
        return s.substring(start, start + minlen);
    }
}
 */

class Solution {

    public String minWindow(String s, String t) {

        // Frequency map for characters in t
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;

        // Number of characters still needed
        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // If character is useful
            if (map.containsKey(ch)) {

                // Needed character found
                if (map.get(ch) > 0) {
                    required--;
                }

                // Decrease frequency
                map.put(ch, map.get(ch) - 1);
            }

            // Window becomes valid
            while (required == 0) {

                int windowLen = right - left + 1;

                // Update minimum answer
                if (windowLen < minLen) {
                    minLen = windowLen;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character
                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1);

                    // Window becomes invalid
                    if (map.get(leftChar) > 0) {
                        required++;
                    }
                }

                // Shrink window
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
