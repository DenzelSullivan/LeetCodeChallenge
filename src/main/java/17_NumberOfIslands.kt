/**
 * Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 * */

fun main() {
    val ex1 = arrayOf(
            "11110".toCharArray(),
            "11010".toCharArray(),
            "11000".toCharArray(),
            "00000".toCharArray()
    )

    val ex2 = arrayOf(
            "11000".toCharArray(),
            "11000".toCharArray(),
            "00100".toCharArray(),
            "00011".toCharArray()
    )

    println(numIslands(ex1)) // 1
    println(numIslands(ex2)) // 3
}

fun numIslands(grid: Array<CharArray>): Int {
    var count = 0
    for (row in grid.withIndex()) {
        for (col in row.value.withIndex()) {
            if (col.value == '1') {
                count++
                merge(grid, row.index, col.index)
            }
        }
    }

    return count
}

fun merge(grid: Array<CharArray>, rowIndex: Int, colIndex: Int) {
    val totalRows = grid.size
    val totalCols = grid[0].size

    if (rowIndex < 0 || rowIndex >= totalRows ||
            colIndex < 0 || colIndex >= totalCols ||
            grid[rowIndex][colIndex] != '1')
        return

    grid[rowIndex][colIndex] = 'X';

    merge(grid, rowIndex - 1, colIndex) // left
    merge(grid, rowIndex + 1, colIndex) // right
    merge(grid, rowIndex, colIndex - 1) // above
    merge(grid, rowIndex, colIndex + 1) // below
}