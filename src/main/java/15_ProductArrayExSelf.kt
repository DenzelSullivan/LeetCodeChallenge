/**
 * Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal
 * to the product of all the elements of nums except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array
 * (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 * */

fun main(){
    println(productExceptSelf(intArrayOf(1,2,3,4)).toList())
}


// O(n^2) solution.
fun productExceptSelf(nums: IntArray): IntArray {
    val products = mutableListOf<Int>()
    for ((index1, num1) in nums.withIndex()){
        var p = 1
        for((index2, num2) in nums.withIndex()){
            if(index1 != index2){
                p = p.times(num2)
            }
        }
        products.add(p)
    }

    return products.toIntArray()
}