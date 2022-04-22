package solved.easy;


class Solution1275Test{

    public static void main(String[] args){
        Solution1275 solution1275 = new Solution1275();
        int[][] moves = new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(solution1275.tictactoe(moves) == "A");
        moves = new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(solution1275.tictactoe(moves) == "B");
        moves = new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        System.out.println(solution1275.tictactoe(moves) == "DRAW");
    }

}