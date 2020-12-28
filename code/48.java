class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0, max = 0;

        while(right < s.length()) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));

                left++;

            }

            set.add(s.charAt(right));

            right++;

            max = Math.max(right - left, max);

        }

        return max;

    }

}