import java.math.BigInteger

fun quickSort(numbers: List<Int>): List<Int> =
    if (numbers.isEmpty()) {
        numbers
    } else {
        val pivot = numbers.first()
        val tail = numbers.drop(1)
        val lessOrEqual = tail.filter { e -> e <= pivot }
        val larger = tail.filter { e -> e > pivot }
        quickSort(lessOrEqual) + pivot + quickSort(larger)
    }

fun fac(n : Int) : BigInteger =
    (1..n).fold(BigInteger("1")) { product, e -> product * e.toBigInteger()}