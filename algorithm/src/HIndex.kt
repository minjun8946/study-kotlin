fun hIndex(citations: IntArray): Int {
    var a = 0
    var b = 0
    for(i in citations.indices){
        for(j in citations.indices){
            if(j > citations[i]){
                a++
            }
        }
        if(a==i) return a
    }
    return a
}