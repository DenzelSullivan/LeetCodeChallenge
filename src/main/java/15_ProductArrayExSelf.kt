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

fun main() {
    println(productExceptSelf(intArrayOf(1, 2, 3, 4)).toList())
}

fun productExceptSelf(nums: IntArray): IntArray {
    val length = nums.size
    val products = IntArray(length)
    products[0] = 1

    // getting products to the left of nums[i]
    for (i in 1 until length) {
        products[i] = nums[i - 1] * products[i - 1]
    }

    // getting products to the right of nums[i] and getting final product
    var right = 1
    for (i in length - 1 downTo 0){
        products[i] = products[i] * right
        right *= nums[i]
    }

    return products
}
// O(n^2) solution.
/*
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
}*/
