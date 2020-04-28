/**
 * Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * */

fun main(){
    println(canJump(intArrayOf(2,3,1,1,4))) // true
    println(canJump(intArrayOf(3,2,1,0,4))) // false
    println(canJump(intArrayOf(2,5,0,0))) // true
}

private fun canJump(nums: IntArray): Boolean {
    if (nums.size == 1) return true
    var current = 0
    var previous = 0
    val end = nums.lastIndex
    while (current != end){
        val maxStep = nums[current]
        //println(maxStep)

        if(current + maxStep >= end){
            return true
        }
        previous = current
        current += maxStep

        if(current == previous){
            return false
        }
    }

    return false
}