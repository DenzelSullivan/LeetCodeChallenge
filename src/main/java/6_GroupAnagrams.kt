/**
 * Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 *
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * */
fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
    println(groupAnagrams(arrayOf("tea","","eat","","tea","")))
    println(groupAnagrams(arrayOf("", "")))
    println(groupAnagrams(arrayOf("", "b")))
    println(groupAnagrams(arrayOf("paw","dad","bog","day","day","mig","len","rat")))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return emptyList()
    val wordMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    for (s in strs) {
        val charArray = s.toCharArray().sorted()
        val key = charArray.toString()
        if (!wordMap.containsKey(key)) wordMap[key] = arrayListOf()
        wordMap[key]?.add(s)
    }
    return wordMap.values.toList()
}

// Works but has to long of a runtime.
/*fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val anagramList = mutableListOf<List<String>>()
    val removedStrings = mutableListOf<String>()

    for (groupString in strs) {
        val anagramStrings = mutableListOf<String>()
        val splitString = groupString.split("").sorted()
        for (checkedString in strs) {
            val c = checkedString.split("").sorted()
            if(c == splitString && !removedStrings.contains(checkedString)){
                anagramStrings.add(checkedString)
            }
        }
        if (anagramStrings.isNotEmpty()) {
            anagramList.add(anagramStrings)
            removedStrings.addAll(anagramStrings)
        }
    }

    return anagramList
}*/
