/**
 *
 * Diameter of Binary Tree
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * */

fun main() {
    val root = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)

    node2.apply {
        left = node4
        right = node5
    }

    root.apply {
        left = node2
        right = node3
    }

    println(diameterOfBinaryTree(root))
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    return visit(root!!)
}

// Todo: Not complete. Currently find value from root to lowest node.
//  Need longest route between any two nodes
fun visit(node: TreeNode?): Int{
//    if (node == null) return 0

    val value = node?.`val` // for printing
    val left = node?.left
    val right = node?.right

//    println("${node.`val`}: $node")

    val leftSum = if (left != null) visit(left) + 1 else 0
    println("$value: leftSum = $leftSum")

    val rightSum = if (right != null) visit(right) + 1 else 0
    println("$value: rightSum = $rightSum")

    println("$value: done")

    return if(leftSum > rightSum) leftSum else rightSum
}

/*fun visit(node: TreeNode?, total: Int): Int {
    if (node == null) return 0

    println("${node.`val`}: $node")

    return if(visit(node.left, total) > visit(node.right, total)){
        visit(node.left, total) + total
    } else {
        visit(node.right, total) + total
    }
}*/

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String = "[left = ${left?.`val`}, right = ${right?.`val`}]"
}