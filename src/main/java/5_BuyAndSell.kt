/**
 * Best time to buy and sell stock 2
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as
 * you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.

 * */

fun main() {
    println(maxProfit(listOf(7, 1, 5, 3, 6, 4).toIntArray())) // 7
    println(maxProfit(listOf(1, 2, 3, 4, 5).toIntArray())) // 4
    println(maxProfit(listOf(7, 6, 4, 3, 1).toIntArray())) // 0
}

// only actually buy if there is a later day with a larger value
// sell on the largest date after buy
// ie 1,2,3. buy on 1 sell on 3.
// ie 3,2,1. do nothing.
// ie 2,1,3. buy on 2 sell on 3.

fun maxProfit(prices: IntArray): Int {
    var total = 0
    var buyPrice = 0
    var canBuy = true

    println(prices.toList())
    for (i in 0..prices.lastIndex) {
        val day = i + 1
        val currentPrice = prices[i]
        val nextPrice = if (i != prices.lastIndex) prices[i+1] else 0

        // Skipping. Can buy but next day has a lower price
        if (canBuy && currentPrice > nextPrice){
            println("Skipping: Day: $day ")
            continue
        }
        // Buying. Next price is higher
        else if (canBuy && currentPrice < nextPrice) {
            println("Buying. Day: $day Price: $currentPrice")
            buyPrice = currentPrice
            canBuy = false
        }
        // Holding. Waiting to see if next day is better unless its the last day
        else if (!canBuy && currentPrice < nextPrice && nextPrice != 0){
            println("Holding. Day: $day")
        }
        // Selling. Other rules couldn't hold. Time to sell $$$
        else if (!canBuy && currentPrice > buyPrice) { //sell
            println("Selling. Day: $day SellingPrice: $currentPrice BuyingPrice: $buyPrice Gain: ${currentPrice - buyPrice}")
            total = total.plus(currentPrice.minus(buyPrice))
            canBuy = true
        }
    }

    return total
}

