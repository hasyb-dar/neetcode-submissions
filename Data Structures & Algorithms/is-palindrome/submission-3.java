class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        str = str.replaceAll("[^a-z0-9]", ""); // remove commas, spaces, symbols

        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
