public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, currentSum = 0;

        while (left < right) {
            currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
