package number.of.islands;

public class SolutionTest {

    public static void test1() {
        char[][] grid = new char[][] {
            { '1', '1', '1', '1', '0' },
            { '1', '1', '0', '1', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '0', '0', '0' }
        };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid) == 1);
    }
    public static void test2() {
        char[][] grid = new char[][] {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
          };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid) == 3);
    }
    public static void main(String args[]) {
        test1();test2();
    }
}