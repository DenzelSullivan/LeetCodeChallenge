/**
 * Backspace String Compare
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 *
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 *
 * */

fun main(){
    println(backspaceCompare("ab#c", "ad#c")) // true
    println(backspaceCompare("ab##", "c#d#")) // true
    println(backspaceCompare("a##c", "#a#c")) // true
    println(backspaceCompare("a#c", "b")) // false
}

fun backspaceCompare(S: String, T: String): Boolean {
    var first = ""
    var second = ""

    for (value in S){
        first = backspaceReplace(value, first)
    }

    for (value in T){
        second = backspaceReplace(value, second)
    }

    return first == second
}

fun backspaceReplace(value: Char, final: String): String{
    val hash = '#'
    return when {
        value != hash -> { final.plus(value) }
        value == hash && final.isNotEmpty() -> {
            final.replaceRange(final.length - 1 until final.length, "")
        }
        else -> {
            final
        }
    }
}