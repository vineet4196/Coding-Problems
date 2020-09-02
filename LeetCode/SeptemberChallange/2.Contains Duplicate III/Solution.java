/**
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
   Hide Hint #1  
Time complexity O(n logk) - This will give an indication that sorting is involved for k elements.
   Hide Hint #2  
Use already existing state to evaluate next state - Like, a set of k sorted numbers are only needed to be tracked. 
When we are processing the next number in array, then we can utilize the existing sorted state and it is not necessary to sort next overlapping set of k numbers again.
**/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        //sliding window approach. set always contains unique value.
        //when tree set size reaches 3 then remove first from tree set.
        //Tree set is used to maintain sorted order.
        //Tree set is kind of self balancing tree store values in ascending order
    
        TreeSet<Integer> ts= new TreeSet<>();
                
        for(int i=0;i<nums.length;i++) {
            
            int c = nums[i];
            
            //check for absolute differnce before adding to tree set
            //floor return null if no element present in tree set
            //otherwise return first minimum or equal value, to given value
            if(ts.floor(c)!=null && c<=ts.floor(c)+t) {
                return true;
            }
            
            /** ceiling  used to return the least element in this set greater than or equal to the given                       element,or null if there is no such element i.e it will return first greater value
            than element or null other wise**/
            
            if(ts.ceiling(c) !=null && c>=ts.ceiling(c)-t) {
                return true;
            }
               
            ts.add(c);
            
            //this will check for k i.e index differnce.
            if(i>=k) {
                //remove from start if no such element found
                ts.remove(nums[i-k]);
            }   
        }
        return false;   
    }
}
