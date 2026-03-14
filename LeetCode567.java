import java.util.HashMap;
import java.util.Map;

public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c :  s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i)) && i + s1.length() <= s2.length()) {
                Map<Character, Integer> temp = new HashMap<>(map);
                for (int j = i; j < s1.length() + i; j++) {
                    char c = s2.charAt(j);
                    if (temp.containsKey(c)) {
                        temp.put(c, temp.get(c) - 1);
                        if (temp.get(c) < 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                boolean allZero = temp.values().stream().allMatch(v -> v == 0);
                if (allZero) return true;
            }
        }
        return false;
    }
}
