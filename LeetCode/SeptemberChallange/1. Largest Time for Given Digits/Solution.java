/**
 Largest Time for Given Digits

Solution
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9
**/


/**
 Solution
**/

class Solution {
    
    //Find all the permutations. // Will permute using visited array
    //validate time in permutation
    //Add return list
    
    public String largestTimeFromDigits(int[] A) {
        
        // required Data-Structure.
        List<List<Integer>> listOFPossibleTimes= new ArrayList<>();
        List<Integer> timeArrayAtLeafNode= new ArrayList<>();
        List<String> validTime= new ArrayList<>();
        boolean visited[]= new boolean[4];
        
        //permutation
        permutation(listOFPossibleTimes,A,timeArrayAtLeafNode,visited);
        
        //create valid time list.
        for(int i=0;i<listOFPossibleTimes.size();i++){
            
            List<Integer> tempTimeList  = listOFPossibleTimes.get(i);
            String stringToValidate="";
            
            for(int j=0;j<tempTimeList.size();j++){
                stringToValidate+= Integer.toString(tempTimeList.get(j));
            }
            
            if(validateTime(stringToValidate)) validTime.add(stringToValidate);
        }
        
        //sort to get maximum time at end.
        Collections.sort(validTime);
        
        // return value
        String time = "";
        
        if(validTime.size() >0) { 
            String temp = validTime.get(validTime.size() -1);
            time = String.format("%s:%s", temp.substring(0, 2), temp.substring(2));
        }
        
        return time; 
    }
    
    private boolean validateTime(String s){
        
        if(s.charAt(0) > '2' ) return false;
        
        if(s.charAt(0)=='2'){
            if(s.charAt(1) > '3') return false;
        }
        
        if(s.charAt(2) > '5') return false;
        
        return true;
    }

    private void permutation(List<List<Integer>> res,int[] nums,List<Integer> curr, boolean visited[]){
        //base condition for permutation(i.e. Tree reaches at leaf node)
        // Add time to list of possible times.
        
        if(curr.size()==nums.length){
            res.add(new ArrayList(curr));
            return;
        }
        
        // iterate over input array and permutate on array.
        for(int i=0;i<nums.length;i++){
            
            if(visited[i]==true) continue;
            
            //add current i value of into list of Interger at a level of tree.       
            curr.add(nums[i]);
            visited[i]=true;
            
            // permutate on current i value.
            permutation(res,nums,curr,visited);
            
            //backtrack. Undo your chnages.
            visited[i]=false;
            curr.remove(curr.size()-1); // remove last from current array list for next possible permutation.     
        }
    }
}

