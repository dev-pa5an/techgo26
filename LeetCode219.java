import java.util.HashMap;
import java.util.Map;

public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int currDiff = i - map.get(nums[i]);
                if (currDiff <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
