package solved.easy;
import java.util.HashSet;

class Solution696 {

    private int iterateCombination(int leftIndex, int rightIndex, String s, int counter, char left, char right){
        int length = s.length();
        while(leftIndex >=0 && rightIndex < length){
            if(s.charAt(leftIndex)==left && s.charAt(rightIndex) == right){
                counter++;
                leftIndex--;
                rightIndex++;
            }else{
                break;
            }
        } 
        
        return counter;
    }    

    private int spreadCount(int index, String s,int counter){
        int leftIndex = index;
        int rightIndex = index+1;
        if(rightIndex == s.length()) return 0;
        if(s.charAt(leftIndex) == '0'){
            counter = iterateCombination(leftIndex, rightIndex, s, counter, '0', '1');  
        }else {
            counter = iterateCombination(leftIndex, rightIndex, s, counter, '1', '0'); 
        }
        
        return counter;
    }

    public int countBinarySubstrings(String s) {
        // collect all the indexes where the string changes from 0 to 1
        // for each index collected, spread in both direction and as long as its same,
        // increase the counter
        int counter = 0;
        HashSet<Integer> breakPointHashSet = new HashSet<>();
        int length = s.length();
        for(int i=0;i<length-1;i++){
            if(s.charAt(i)!= s.charAt(i+1)) breakPointHashSet.add(i);    
        }
        for(Integer i:breakPointHashSet){
            counter = spreadCount(i,s,counter);
        }
        return counter;
    }
}