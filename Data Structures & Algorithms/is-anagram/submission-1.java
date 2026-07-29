class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int m = t.length();
        char[] ar = t.toCharArray();
        int[] freqarr = new int[26];
        int[] freqar = new int[26];
        for(int i=0; i<m; i++){
            freqar[ar[i]-'a']++;
        }
        for(int i=0; i<n; i++){
            freqarr[arr[i]-'a']++;
        }
        //boolean yes = false;
        for(int i=0; i<26; i++){
            if(freqar[i]!=freqarr[i]){
                return false;
            }
        }
        return true;
    }
}
