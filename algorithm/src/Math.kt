fun math(n : Int){
    val answer = mutableListOf(0,0,0,0,0,0,0,0,0,0,0)
    for(i in 1..n){
        answer[(1..6).random() + (1..6).random()-2]++
    }
    for(i in 2..12){
        println("눈의 합${i} = ${answer[i-2]}회")
    }
}