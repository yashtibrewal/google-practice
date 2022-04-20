package solved;

class Solution121Test {

    public static Solution121 solution;

    public static void test1() {
        int[] prices= new int[]{7,1,5,3,6,4};
        solution = new Solution121();
        System.out.println(solution.maxProfit(prices) == 5);
    }

    public static void test2() {
        int[] prices= new int[]{7,6,4,3,1};
        solution = new Solution121();
        System.out.println(solution.maxProfit(prices) == 0);
    }

    public static void testIsDescendingOrder1(){
        int[] prices= new int[]{7,6,4,3,1};
        solution = new Solution121();
        System.out.println(solution.isDescendingOrder(prices));
    }
    public static void testIsDescendingOrder2(){
        int[] prices= new int[]{7,6,10,3,1};
        solution = new Solution121();
        System.out.println(!solution.isDescendingOrder(prices));
    }
    public static void main(String args[]) {
        testIsDescendingOrder1();
        testIsDescendingOrder2();
        test1();test2();
    }
}