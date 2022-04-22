package solved.easy;
import java.util.ArrayList;
import java.util.List;

public class Solution1304 {
    
    public int[] sumZero(int n) {
        // if n is even
        int[] result = new int[n];
        if(n%2==1){
            int counter = 0;
            int leftIndex = 0;
            int rightIndex= n-1;
            int value = n/2;
            while(counter<=n/2){
                if(leftIndex == rightIndex) break;
                result[leftIndex] = value;
                result[rightIndex] = -1 * value;
                value--;
                leftIndex++;
                rightIndex--;
                counter++;
            }
        }else {
            int counter = 0;
            int leftIndex = 0;
            int rightIndex= n-1;
            int value = n/2;
            while(counter<=n/2){
                if(leftIndex > rightIndex) break;
                result[leftIndex] = value;
                result[rightIndex] = -1 * value;
                value--;
                leftIndex++;
                rightIndex--;
                counter++;
            }
        }
        return result;
    }

}
