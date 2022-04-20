package solved;


class Solution696Test{

    public static void test1(){
        Solution696 solution696 = new Solution696();
        System.out.println(solution696.countBinarySubstrings("00110011")==6);
    }
    public static void test2(){
        Solution696 solution696 = new Solution696();
        System.out.println(solution696.countBinarySubstrings("10101")==4);
    }
    public static void main(String args[]){
        test1();
        test2();
    }

}