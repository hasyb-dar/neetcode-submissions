class Solution {
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
