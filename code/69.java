class Solution {
    public int maxProfit(int[] prices) {
        int result=0;

        for(int i=1;i<prices.length;i++)

        {
            result = Math.max(result,prices[i]-prices[i-1]);

            prices[i] = Math.min(prices[i],prices[i-1]);

        }

        return result;

    }

}