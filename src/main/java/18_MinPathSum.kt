/**
 * Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 * Input:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * */

fun main(){
    val row1 = intArrayOf(1,3,1)
    val row2 = intArrayOf(1,5,1)
    val row3 = intArrayOf(4,2,1)
    println(minPathSum(arrayOf(row1, row2, row3)))
}

fun minPathSum(grid: Array<IntArray>): Int {
    val minTotalSum = Array(grid.size) { IntArray(grid[0].size) }
    for (row in grid.indices) {
        for (column in grid[row].indices) {
            if (row == 0) {
                if (column == 0) {
                    // first item (top left)
                    minTotalSum[row][column] = grid[row][column]
                } else {
                    minTotalSum[row][column] = minTotalSum[row][column - 1] + grid[row][column]
                }
            } else {
                if (column == 0) {
                    minTotalSum[row][column] = minTotalSum[row - 1][column] + grid[row][column]
                } else {
                    val minimumSum = Math.min(minTotalSum[row - 1][column], minTotalSum[row][column - 1])
                    minTotalSum[row][column] = minimumSum + grid[row][column]
                }
            }
        }
    }
    return minTotalSum[grid.size - 1][grid[0].size - 1]
}