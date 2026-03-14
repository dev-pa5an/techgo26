
public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26]; //this is the sliding window

        for (int i = 0; i < n1; i++) { //n1 = 2, n2 = 8
            s1Count[s1.charAt(i) - 'a']++; //'ab' -> [1,1,0,0,0...]
            s2Count[s2.charAt(i) - 'a']++; //'eidbaooo' -> [0,0,0,0,1,0,0,0,1,0,0,0...]
        }
        for (int i = 0; i < n2 - n1; i++) {
            if (matches(s1Count, s2Count)) return true;
            s2Count[s2.charAt(i) - 'a']--;
            s2Count[s2.charAt(i+n1) - 'a']++;
        }
        return matches(s1Count, s2Count);
    }
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }
}
