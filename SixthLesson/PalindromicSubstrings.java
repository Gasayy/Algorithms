package SixthLesson;

class Solution
{
    public int countSubstrings(String inputString)
    {
        int noOfPalindromicSubStrings = 0;
        for(int idx=0; idx<inputString.length(); idx++)
        {
            int oddSizedSubStrings  = countPalindromesFromCenter(inputString, idx, idx);
            int evenSizedSubStrings = countPalindromesFromCenter(inputString, idx, idx+1);

            noOfPalindromicSubStrings +=  oddSizedSubStrings + evenSizedSubStrings;
        }
        return noOfPalindromicSubStrings;
    }
    public int countPalindromesFromCenter(String inputString, int leftIdx, int rightIdx)
    {
        int noOfPalindromes = 0;

        while(leftIdx >= 0 && rightIdx < inputString.length() && inputString.charAt(leftIdx--) == inputString.charAt(rightIdx++))
        {
            noOfPalindromes++;
        }
        return noOfPalindromes;
    }
}