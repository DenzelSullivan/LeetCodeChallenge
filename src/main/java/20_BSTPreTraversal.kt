/**
 *   Construct Binary Search Tree from Pre-order Traversal
 *
 * Return the root node of a binary search tree that matches the given pre-order traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left
 * has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a pre-order traversal displays the value of the node first, then traverses node.left,
 * then traverses node.right.)
 * */

fun main() {
    println(bstFromPreorder(intArrayOf(8,5,1,7,10,12))) // 8,5,10,1,7,null,12
}

var nodeIndex = 0
fun bstFromPreorder(preorder: IntArray): TreeNode? {
    return bstHelper(preorder, Int.MIN_VALUE, Int.MAX_VALUE)
}

private fun bstHelper(preorder: IntArray, start: Int, end: Int): TreeNode? {
    if (nodeIndex == preorder.size || preorder[nodeIndex] < start || preorder[nodeIndex] > end) {
        return null
    }
    val nodeValue = preorder[nodeIndex++]
    val node = TreeNode(nodeValue)
    node.left = bstHelper(preorder, start, nodeValue)
    node.right = bstHelper(preorder, nodeValue, end)
    return node
}

