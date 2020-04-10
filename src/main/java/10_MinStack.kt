/**
 * Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * */

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())   // -3.
    minStack.pop()
    println(minStack.top())      // 0.
    println(minStack.getMin())  //  -2.
}

class MinStack {
    data class Node(var value: Int, var min: Int)

    private var stack = mutableListOf<Node>()

    fun push(x: Int) {
        val min = if(stack.isNotEmpty() && getMin() < x) getMin() else x
        val node = Node(value = x, min = min)
        stack.add(node)
    }

    fun pop() = stack.removeAt(stack.lastIndex)

    fun top(): Int = getNode().value

    fun getMin(): Int = getNode().min

    private fun getNode() = stack[stack.lastIndex]
}