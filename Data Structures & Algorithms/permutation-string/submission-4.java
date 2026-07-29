/* class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        HashMap<Character,Integer> freq = new HashMap();
        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) + 1);
            }else{
                freq.put(ch, 1);
            }
        }
        
        int i = 0;
        while(i<m){
            char ch = s2.charAt(i);
            int j = i;
            if (freq.containsKey(ch)){
                int l =0;
                while(j<i+n){
                    char c = s2.charAt(j);
                    if (freq.containsKey(c)){
                        if (freq.get(c) > 0) l++;
                        freq.put(c, freq.get(c) - 1);
                    }
                    j++;
                }
                if(l==n){
                    return true;
                }
            }
             i+=1;
        }
        return false;
    }
} */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int i = 0;

        while (i < m) {
            char ch = s2.charAt(i);
            int j = i;

            if (freq.containsKey(ch)) {

                int l = 0;
                HashMap<Character, Integer> backup = new HashMap<>(freq); // ✅ FIX 1: backup s1="adc" s2="dcda" code one breaks here

                while (j < m && j < i + n) { 
                    char c = s2.charAt(j);

                    if (freq.containsKey(c)) {
                        if (freq.get(c) > 0) l++;
                        freq.put(c, freq.get(c) - 1);
                    } else {
                        break; 
                    }
                    j++;
                }

                if (l == n) {
                    return true;
                }

                freq = backup; 
            }

            i++;
        }

        return false;
    }
}
