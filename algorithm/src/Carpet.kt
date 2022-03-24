class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        val tile = brown + yellow
        var result = mutableListOf<Int>()
        for(i in tile downTo 3){
            if(tile % i == 0 && yellow % (i-2) == 0){
                result.add(i)
                result.add(tile/i)
                break
            }
        }
        answer = result.toIntArray()
        return answer
    }
}