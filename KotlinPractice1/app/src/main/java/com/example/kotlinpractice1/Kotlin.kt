package com.example.kotlinpractice1

import java.util.*

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        var change = numbers
        for(i in numbers.indices){
            for(j in numbers.indices){
                change[j].minus(change[j]*2)
                if(change.sum() == target){
                    answer++
                }
            }
        }
        return answer
    }
}