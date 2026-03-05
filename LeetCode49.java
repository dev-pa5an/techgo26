import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = new char[26];
            for (int j = 0; j < strs[i].length(); j++) {
                chars[strs[i].charAt(j) - 'a'] += 1;
            }
            strMap.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(strMap.values());
    }
}
