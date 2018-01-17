/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

/**
 *
 * @author manji
 * 
 * Q10. The cost of a stock on each day is given in an array, find the max profit
that you can make by buying and selling in those days. For example, if the given
 array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by
 buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the
  given array of prices is sorted in decreasing order, then profit cannot be
  earned at all.
 * 
 * Main Function:
 * System.out.println(maximumProfit(new int[] {100, 180, 260, 310, 40, 535, 695}));
 */
public class stockBuySellToMaximizeProfit {
    public static int maximumProfit(int[] arr){
        if(arr.length <= 1)
            return 0;
        int low = 0, high = 0, profit = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                high = i-1;
                if(low != high){
                    System.out.println("Buy on day : " + low + " Sell on day : " + high);
                    profit += arr[high]-arr[low];
                }
                low = i;
            }
        }
        high = arr.length-1;
        if(low != high){
            System.out.println("Buy on day : " + low + " Sell on day : " + high);
            profit += arr[high]-arr[low];
        }
        return profit;
    }
}
