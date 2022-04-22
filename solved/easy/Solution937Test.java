package solved.easy;
import java.util.ArrayList;
import java.util.Collections;

class Solution937Test{

    static void printString(String[] results){
        ArrayList<String> printableResults = new ArrayList<>(results.length);
        Collections.addAll(printableResults, results);
        System.out.println(printableResults);
    }
    public static void main(String[] args){
        Solution937 solution937 = new Solution937();
        String[] inputs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        printString(solution937.reorderLogFiles(inputs));
        inputs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        printString(solution937.reorderLogFiles(inputs));
        
    }

}