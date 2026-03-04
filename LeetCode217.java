import java.util.HashMap;
import java.util.Map;

public class LeetCode217 {
    public boolean containsDuplicate(int[] nums) {
        int p = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        while (p < nums.length) {
            if (map.containsKey(nums[p])){
                return true;
            } else {
                map.put(nums[p], true);
                p += 1;
            }
        }
        return false;
    }
}
