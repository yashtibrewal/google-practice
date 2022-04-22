public class Solution2128Test {
    public static void main(String[] args) throws Exception {
        Solution2128 solution2128 = new Solution2128();
        int[][]grid = new int[][]{{0,1,0},{1,0,1},{0,1,0}};
        System.out.println(solution2128.removeOnes(grid) == true);
        grid = new int[][]{{1,1,0},{0,0,0},{0,0,0}};
        System.out.println(solution2128.removeOnes(grid) == false);
        grid = new int[][]{{1}};
        System.out.println(solution2128.removeOnes(grid) == true);
    }
}
