class Solution {
    public boolean isAnagram(String s, String t) {

        // Step 1: Quick length check
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create a HashMap to store character counts
        // Key = character, Value = frequency count
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 3: Count characters from the first string
        for (char c : s.toCharArray()) {
            // If character already exists, increment count
            // Otherwise, put it with count = 1
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 4: Subtract counts using the second string
        for (char c : t.toCharArray()) {
            // If character not found in map → not an anagram
            if (!map.containsKey(c)) {
                return false;
            }

            // Reduce the count for this character
            map.put(c, map.get(c) - 1);

            // If count becomes zero, remove the entry
            // (keeps map clean and helps final check)
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        // Step 5: Final check
        // If map is empty → all counts balanced → valid anagram
        return map.isEmpty();
    }

}
