import kotlin.math.max

/**
 * Contiguous Array
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * */

fun main(){
    println(findMaxLength(intArrayOf(0,1))) // 2
    println(findMaxLength(intArrayOf(0,1,0))) // 2
    println(findMaxLength(intArrayOf(0,1,0,1,0,0,0,1,1,0,1,1))) // 2
    println(findMaxLength(intArrayOf(0,1,0,1,0,1,1,0,1,1))) // 2
}

fun findMaxLength(nums: IntArray): Int {
    val countsMap: HashMap<Int, Int> = HashMap()
    var maxSize = 0
    var count = 0
    for(n in nums.withIndex()){
        count = if (n.value == 1)
            count.plus(1)
        else
            count.minus(1)

        if (count == 0) maxSize = max(maxSize, n.index.plus(1))
        if(countsMap.containsKey(count)){
            // count has been seen before, check current max with the one from before
            maxSize = max(maxSize, n.index.minus(countsMap[count] ?: 0))
        } else {
            // count has not been seen before, add it and index
            countsMap[count] = n.index
        }
        println("value: ${n.value} maxSize: $maxSize, count:$count, map:$countsMap")
    }
    return maxSize
}