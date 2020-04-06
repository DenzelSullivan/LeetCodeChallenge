/**
 * Maximum SubArray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 *
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

fun main() {
    val list = listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).toIntArray()
    val max = maxSubArray(list)
    println(max)
}

// O(n) solution
fun maxSubArray(nums: IntArray): Int {
    val size: Int = nums.size
    var maxSoFar = nums[0]
    var maxEndingHere = 0

    for (i in 0 until size) {
        if (nums[i] > maxEndingHere + nums[i])
            maxEndingHere = nums[i]
        else
            maxEndingHere += nums[i]

        if (maxSoFar < maxEndingHere)
            maxSoFar = maxEndingHere
    }

    return maxSoFar
}


// Brute Force - O(n^2)
/*fun maxSubArray1(nums: IntArray): Int {
    var max = nums[0]
    val size = nums.size
    for (i in 0 until size) {
        for (j in i until size){
            val sub = nums.toList().subList(i,j+1)
            if (sub.sum() > max){
                max = sub.sum()
            }
        }
    }

    return max
}*/
