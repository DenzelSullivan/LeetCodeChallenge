import kotlin.math.max

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

var total = 0

fun diameterOfBinaryTree(root: TreeNode?): Int {
    total = 1
    visit(root)
    return total - 1
}

fun visit(node: TreeNode?): Int{
    if (node == null) return 0

    val leftSize = visit(node.left)
    val rightSize = visit(node.right)

    total = max(total, leftSize + rightSize + 1)
    return max(leftSize, rightSize) + 1
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String = "[left = ${left?.`val`}, right = ${right?.`val`}]"
}