import java.util.HashMap;
import java.util.Map;

class LeetCode13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] symbols = {"I", "V", "X", "L", "C", "D", "M", "IV", "IX", "XL", "XC", "CD", "CM"};
        int[] values = {1, 5, 10, 50, 100, 500, 1000, 4, 9, 40, 90, 400, 900};
        for (int i = 0; i < symbols.length; i++) {
            map.put(symbols[i], values[i]);
        }
        if (s.length() == 1) {
            return map.get(s);
        }
        int index = 0;
        int ans = 0;
        while (index < s.length()) {

            // check two-character symbol
            if (index + 1 < s.length() && 
                map.containsKey(s.substring(index, index + 2))) {

                ans += map.get(s.substring(index, index + 2));
                index += 2;

            } else {
                ans += map.get(s.substring(index, index + 1));
                index += 1;
            }
        }
        return ans;
    }
}