/**
 * Valid Parenthesis String
 *
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid.
 * We define the validity of a string by these rules:
 *
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 *
 * Example 1:
 * Input: "()"
 * Output: True
 *
 * Example 2:
 * Input: "(*)"
 * Output: True
 *
 * Example 3:
 * Input: "(*))"
 * Output: True
 * */

fun main(){
    println(checkValidString("()")) // true
    println(checkValidString("(*)")) // true
    println(checkValidString("(*))")) // true
    println(checkValidString(")")) // false
    println(checkValidString("(*()")) // true
    println(checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()")) // false
}

//Todo: review solution and dynamic programming pattern
fun checkValidString(s: String): Boolean {
    val stringLength = s.length
    if (stringLength == 0) return true
    val dp = Array(stringLength) { BooleanArray(stringLength) }
    for (i in 0 until stringLength) {
        if (s[i] == '*') dp[i][i] = true
        if (i < stringLength - 1 &&
                (s[i] == '(' || s[i] == '*') &&
                (s[i + 1] == ')' || s[i + 1] == '*')) {
            dp[i][i + 1] = true
        }
    }
    for (size in 2 until stringLength) {
        var i = 0
        while (i + size < stringLength) {
            if (s[i] == '*' && dp[i + 1][i + size]) {
                dp[i][i + size] = true
            } else if (s[i] == '(' || s[i] == '*') {
                for (k in i + 1..i + size) {
                    if ((s[k] == ')' || s[k] == '*') &&
                            (k == i + 1 || dp[i + 1][k - 1]) &&
                            (k == i + size || dp[k + 1][i + size])) {
                        dp[i][i + size] = true
                    }
                }
            }
            i++
        }
    }
    return dp[0][stringLength - 1]
}
