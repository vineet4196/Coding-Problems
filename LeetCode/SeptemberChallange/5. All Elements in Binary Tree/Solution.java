/**
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].

Hide Hint #1  
Traverse the first tree in list1 and the second tree in list2.

Hide Hint #2  
Merge the two trees in one list and sort it.

**/




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traverseTee(root1,list1);
        traverseTee(root2,list2);
        
       // Collections.sort(result);
        
        return sortedList(list1,list2);
    }
    //Inoder traversal gives tree values in sorted order
  public void traverseTee(TreeNode root,List<Integer> list){
        if(root==null)
            return;
      
      traverseTee(root.left,list);
      list.add(root.val);
      traverseTee(root.right,list);
    }
    
    //sort list
    public List<Integer> sortedList( List<Integer> list1,List<Integer> list2){
        
        List<Integer> list = new ArrayList();
        
        int i=0,j=0;
        
        while(i<list1.size() && j<list2.size())
        {
            if(list1.get(i)<list2.get(j)){
                list.add(list1.get(i++));
            }
            else{
                list.add(list2.get(j++));
            }
        }
        
        // add remaining valuse
       while(i<list1.size()) list.add(list1.get(i++));
       while(j<list2.size()) list.add(list2.get(j++));
        
    return list;
    }
}
