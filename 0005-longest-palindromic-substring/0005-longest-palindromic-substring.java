class Solution {
    public String longestPalindrome(String s) {

        char[] arr = s.toCharArray();

        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {

            // Odd length palindrome 
            int left = i;
            int right = i;

            while (left >= 0 && right < arr.length
                    && arr[left] == arr[right]) {

                left--;
                right++;

                int length = right - left - 1;

                if (length > maxLength) {
                    maxLength = length;
                    start = left + 1;
                }
            }

            //  Even length palindrome
            left = i;
            right = i + 1;

            while (left >= 0 && right < arr.length
                    && arr[left] == arr[right]) {

                left--;
                right++;

                int length = right - left - 1;

                if (length > maxLength) {
                    maxLength = length;
                    start = left + 1;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}