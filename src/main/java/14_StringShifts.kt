/**
 * Perform String Shifts
 *
 * You are given a string s containing lowercase English letters,
 * and a matrix shift, where shift[i] = [direction, amount]:
 *      * direction can be 0 (for left shift) or 1 (for right shift).
 *      * amount is the amount by which string s is to be shifted.
 *      * A left shift by 1 means remove the first character of s and append it to the end.
 *      * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 * Example 1:
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 *
 * Example 2:
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * */

fun main(){
    val string1 = "abc"
    val shift1 = arrayOf(intArrayOf(0,1), intArrayOf(1,2))

    val string2 = "abcdefg"
    val shift2 = arrayOf(intArrayOf(1,1), intArrayOf(1,1), intArrayOf(0,2), intArrayOf(1,3))

    println(stringShift(string1, shift1)) // cab
    println(stringShift(string2, shift2)) // efgabcd
}

fun stringShift(s: String, shift: Array<IntArray>): String {
    var string = s
    for (a in shift){
        val direction = a[0] // 0 = left, 1 = right
        val amount = a[1]
        val start = string // used for print below

        string = if (direction == 0) { // left shift
            val shiftRange = 0 until amount
            val sub = string.substring(shiftRange)
            val remaining = string.replaceRange(shiftRange, "")
            remaining.plus(sub)
        } else { // right shift
            val shiftRange = string.lastIndex-amount+1..string.lastIndex
            val sub = string.substring(shiftRange)
            val remaining = string.replaceRange(shiftRange, "")
            sub.plus(remaining)
        }

        println("$start -> $string")
    }

    return string
}

