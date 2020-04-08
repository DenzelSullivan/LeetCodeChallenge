/**
 * Middle of the linked list
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Note:
 *
 * The number of nodes in the given list will be between 1 and 100.
 *
 * */

fun main() {
    val sixth = ListNode(6)
    val fifth  = ListNode(5)
    fifth.next = sixth
    val fourth = ListNode(4)
    fourth.next = fifth
    val third = ListNode(3)
    third.next = fourth
    val second = ListNode(2)
    second.next = third
    val head = ListNode(1)
    head.next = second

    println(middleNode(head)?.`val`)
}

fun middleNode(head: ListNode?): ListNode? {
    val nodeList = mutableListOf<ListNode>()
    var current = head
    while (current != null) {
        //println(current.`val`)
        nodeList.add(current)
        current = current.next
    }
    val middle = nodeList.size / 2

    return nodeList[middle]
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
