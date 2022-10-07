package basic

fun main() {
    for (i in 0..3) {
        println(i)
    }
    println("-------------")

    for (i in 0 until 3) {
        println(i)
    }
    println("-------------")

    for (i in 0 .. 6 step 2) {
        println(i)
    }
    println("-------------")

    for (i in 3 downTo 1) {
        println(i)
    }
    println("-------------")

    var numbers = arrayOf(1,2,3)
    for (i in numbers) {
        println(i)
    }
    println("-------------")
    // While 문의 경우 자바와 동일하다.
}