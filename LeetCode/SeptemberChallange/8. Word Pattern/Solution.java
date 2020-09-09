/**
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
**/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        int n=pattern.length();
        String[] list = str.split(" ");

        HashMap<Character,String> map=new HashMap<Character, String>();


        for(int i=0;i<n/2;i++){
            if(!(pattern.charAt(i)==pattern.charAt((n-1)-i) && list[i].equals(list[(n-1)-i]))){
                return false;
            }
            else{

                if(map.containsKey(pattern.charAt(i))){
                    System.out.println(list[i]);
                    if(!(map.get(pattern.charAt(i)).equals(list[i]))){
                      return false;
                    }
                }
                else {
                    if(map.contains)
                    map.put(pattern.charAt(i),list[i]);
                }
            }
        }
        return res;    
    }
}
