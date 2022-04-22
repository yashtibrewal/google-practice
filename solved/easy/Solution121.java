package solved.easy;

class Solution121 {

    public boolean isDescendingOrder(int[] prices) {
        int length = prices.length;
        for(int i=0;i<length-1;i++){
            if(prices[i] < prices[i+1]) return false;
        }
        return true;
    }

    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        if(prices.length == 2){
            if(prices[1] > prices[0]){
                return prices[1]-prices[0];
            }else {
                return 0;
            }
        }
        // if the array is already in descending order return 0
        if(isDescendingOrder(prices))return 0;

        // the last digit is not the lowest.
        // sliding and keeping a record of maximum profit.
        int maxProfit = 0; // default value
        int length = prices.length;
        int lowest = prices[0];
        for(int i=0;i<length-1;i++){
            if(prices[i+1]<lowest){
                lowest = prices[i+1];
            }else {
                if(prices[i+1]-lowest>maxProfit){
                    maxProfit = prices[i+1]-lowest;
                }
            }
        }

        return maxProfit;
    }
}