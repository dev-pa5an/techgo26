import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        //sliding window with varying length
        int left = 0, right = 0, longest = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            
            while (map.get(s.charAt(right)) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            longest = Math.max(longest, right -  left + 1);
        }
        return longest;
    }
}
