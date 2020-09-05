class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> result = new ArrayList<>();
        
        int n=S.length();
        int[] idx = new int[26];
        
        for(int i= 0;i<n;i++) {
            idx[S.charAt(i)-'a'] = i;
        }
        
        int counter=0;
        
        while(counter<n ){
            
            int end = idx[S.charAt(counter)-'a'];
            
            int j=counter;
            while(j<end) {
                
                end = Math.max(end,idx[S.charAt(j)-'a']);
                j++;
                
            }      
            result.add(j-counter+1);
            counter=j+1;       
            
        }
        
        return result;
    }
}
