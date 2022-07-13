package com.example.kotlininaction.chapter7

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

//7.3.4
@RequiresApi(Build.VERSION_CODES.O)
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start
        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): LocalDate = current.apply {
            current = plusDays(1)
        }
    }

@RequiresApi(Build.VERSION_CODES.O)


fun test() {
    val newYear = LocalDate.ofYearDay(2017, 1)

    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}
// 코드에서 ClosedRange<LocalDate>에 대한 확장 함수 iterator를 정의했기 때문에 LocalDate의 범위 객체를 for 루프에 사용할 수 있다.