package solved;
public class Solution1710Test {
    public static void main(String[] args){
        Solution1710 solution1710 = new Solution1710();
        int[][] boxTypes = new int[][]{{1,3},{2,2},{3,1}};
        System.out.println(solution1710.maximumUnits(boxTypes, 4)==8);
        boxTypes = new int[][]{{5,10},{2,5},{4,7},{3,9}};
        System.out.println(solution1710.maximumUnits(boxTypes, 10)==91);
        boxTypes = new int[][]{{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}};
        System.out.println(solution1710.maximumUnits(boxTypes, 35));

    }
}
