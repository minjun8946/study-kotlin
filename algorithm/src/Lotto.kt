
fun lotto(lottos: IntArray, win_nums: IntArray): IntArray {
    var correctNum =0
    var zero = 0

    for(i in lottos.indices){
        when(lottos[i]){
            0 -> zero++
            else -> {
                if(win_nums.contains(lottos[i])){
                    println(lottos[i])
                    correctNum +=1
                }
                else println(lottos[i])
            }
        }
    }
    var answer: IntArray = intArrayOf(zeroCheck(zero+correctNum),zeroCheck(correctNum))

    return answer
}
fun zeroCheck(num : Int): Int {
    return when(num){
        0 -> 6
        else -> 7-num
    }
}