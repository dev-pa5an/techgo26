import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] fList = new List[nums.length + 1];
        int freq = 0;
        for (int n : map.keySet()) {
            freq = map.get(n);
            if (fList[freq] == null) {
                fList[freq] = new ArrayList<>();
            }
            fList[freq].add(n);
        }
        int[] ans = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (index == k) {
                return ans;
            }
            if (fList[i] != null) {
                for (int n : fList[i]) {
                    ans[index] = n;
                    index++;
                }
            }
        }
        return ans;
    }
}
