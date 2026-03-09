import java.util.HashMap;
import java.util.Map;

public class LeetCode953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int rank = 1;
        for (char c : order.toCharArray()) {
            map.put(c, rank);
            rank++;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];  //"hello"
            String w2 = words[i+1];//"leetcode"
            int l1 = w1.length(); //5
            int l2 = w2.length(); //8
            int r1 = 0;
            int r2 = 0;
            if (l1 <= l2) {
                for (int j = 0; j < l1; j++){
                    r1 = map.get(w1.charAt(j));   //(i=0,j=0) -> "hello" -> 'h' -> 1 
                    r2 = map.get(w2.charAt(j)); //(i=1,j=0) -> "leetcode" -> 'l' -> 2
                    if (r1 < r2) {
                        break;
                    } else if (r1 > r2) {
                        return false;
                    }
                }
            } else {
                for (int j = 0; j <= l2; j++){
                    if (j == l2) {
                        return false;
                    }
                    r1 = map.get(w1.charAt(j));   //(i=0,j=0) -> "apple" -> 'h' -> 1 
                    r2 = map.get(w2.charAt(j)); //(i=1,j=0) -> "app" -> 'l' -> 2
                    if (r1 < r2) {
                        break;
                    } else if (r1 > r2) {
                        return false;
                    }
                }
            }
            
        }
        return true;
    }
}
