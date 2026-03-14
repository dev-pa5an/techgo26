public class LeetCode424 {
    public int characterReplacement(String s, int k) { 
        //variable size sliding window + constraint
        //window size = right - left + 1
        //most frequent character count = maxFreq
        //num of characters to replace = window size - maxFreq
        
        //initialize state -> pointers, map/array, result
        int left = 0, right = 0, maxFreq = 0, maxLength = 0;
        int[] count = new int[26];

        //update the state
        for (right = 0; right < s.length(); right++) {
            //expand the window: add the new character
            count[s.charAt(right) - 'A']++;

            //update the max freq found so far in the window
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            //check if the window is valid
            //if window size - maxFreq > k, it's invalid
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
