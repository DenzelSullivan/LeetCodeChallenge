/**
 * Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 **/

fun main() {
    val example1 = listOf(2, 2, 1).toIntArray()
    val example2 = listOf(4, 1, 2, 1, 2).toIntArray()

    val s1 = singleNumber(example1)
    val s2 = singleNumber(example2)

    println("Solutions: $s1 $s2")
}

private fun singleNumber(nums: IntArray): Int {
    val list = mutableListOf<Int>()
    nums.forEach {
        if (list.contains(it)) {
            list.remove(it)
        } else {
            list.add(it)
        }
    }

    println("size: ${list.size}, value: ${list[0]}")

    return list[0]
}
