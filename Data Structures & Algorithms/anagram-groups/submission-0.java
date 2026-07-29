class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            int[] freq = new int[26];
            
            // build frequency
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }
            
            // convert freq to string key
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append(freq[i]).append("#");
            }
            
            String key = keyBuilder.toString();
            
            // store in map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        
        return new ArrayList<>(map.values());

    }
}
