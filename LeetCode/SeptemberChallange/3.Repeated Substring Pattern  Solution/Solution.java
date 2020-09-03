/**
Repeated Substring Pattern

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
**/




/**
Algorithm:-

1) Start For Loop Form Half Length Of Given Input String.
2) Compare last character of first half with second half.
3. length%i==0 for checking even half of string. let length=12 and divide by 5. so 12 cannot divide in 
   5 equal  parts. hence this check for equal halves
   
4) Pick All Possible Sub String And Append The Same In String Builder.
5) Now After Appending Please Check Value Of  String Builder And String and keep reducing string and check
for possible strings.
6) If Both Are Equal By Value Then Return True.
7) Else Return False At The End.

Time Complexity : - O(n^2) .
Space Complexity :- O(n).
**/


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        int length = s.length();
        int start=length/2;
        for(int i=start;i>0;i--) {
            
            if(length%i==0  && s.charAt(i-1)==s.charAt(length-1)) {
                
                String str = s.substring(0,i);
                
                StringBuilder sb = new StringBuilder();
                
                // make substring
                for(int j=0;j<length/i;j++) {
                    sb.append(str);
                }
                
                if(sb.toString().equals(s)) {
                    return true;
                }               
            }      
        }
        return false;
    }
}
