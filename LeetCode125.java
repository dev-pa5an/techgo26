public class LeetCode125 {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(cRight)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
