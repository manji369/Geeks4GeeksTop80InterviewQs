'''
Q10. The cost of a stock on each day is given in an array, find the max profit
that you can make by buying and selling in those days. For example, if the given
 array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by
 buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the
  given array of prices is sorted in decreasing order, then profit cannot be
  earned at all.
'''

def maxProfit(arr):
    if len(arr) <= 1:
        return
    low = 0
    high = 0
    i = 1
    profit = 0
    for i in range(1, len(arr)):
        if arr[i] < arr[i-1]:
            high = i-1
            if low != high:
                print("Buy on day : " + str(low) + " Sell on day : " + str(high))
                profit += arr[high]-arr[low]
            low = i
    high = len(arr)-1
    if low != high:
        profit += arr[high]-arr[low]
        print("Buy on day : " + str(low) + " Sell on day : " + str(high))
    return profit

print("Profit : " + str(maxProfit([100, 181, 180, 260, 310, 40, 535, 695, 1])))
