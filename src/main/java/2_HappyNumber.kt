/**
 * Happy Number
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 *
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 **/

fun main() {
    println("Solutions: ${isHappy(87)}")
}

fun isHappy(num: Int): Boolean {
    var total = num
    val totalsList = mutableListOf<Int>()
    while (total != 1) {
        total = digitTotal(total)

        if (totalsList.contains(total))
            return false

        totalsList.add(total)
    }

    return true
}

fun digitTotal(num: Int): Int {
    val v1 = num.rem(10)
    val v2 = num.minus(v1).div(10)

    return if (v2 <= 9)
        v1.times(v1) + v2.times(v2)
    else
        v1.times(v1) + digitTotal(v2)
}