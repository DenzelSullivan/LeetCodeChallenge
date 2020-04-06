/**
 * Move Zeros
 *
 * Given an array nums, write a function to move all 0's to the end
 * of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * */

fun main(){
    moveZeroes(listOf(0,1,0,3,12).toIntArray())
}

// Todo: Complete a better optimized solution
fun moveZeroes(nums: IntArray): Unit {
    var lastIndex = nums.lastIndex
    var zeroIndex = 0
    val zeroList = mutableListOf<Int>()

    println("start: ${nums.toList()}")

    for (i in 0 until lastIndex){

        if(nums[i] == 0){
            zeroList.add(i)
        } else if (nums[i] != 0 && zeroList.isNotEmpty()){
            nums[zeroList[zeroIndex]] = nums[i]
            nums[i] = 0
            zeroIndex++
        }

        println("$i: ${nums.toList()}")
    }

    println("final: ${nums.toList()}")
}

//Brute force using Bubble Sort - O(n^2)
/*fun moveZeroes(nums: IntArray): Unit {
    var lastIndex = nums.lastIndex
    var zeroCount = 0

    println("start: ${nums.toList()}")

    for (i in 0 until lastIndex){
        for (j in 0 until lastIndex) {
            if (nums[j] == 0) {
                nums[j] = nums[j + 1]
                nums[j + 1] = 0
                zeroCount++
            }
        }
    }

    println("final: ${nums.toList()}")
}*/



