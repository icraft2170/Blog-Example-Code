package basic

fun main() {
    val day = 2
    val result = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        5 -> "금요일"
        6 -> "토요일"
        7 -> "일요일"
        else -> "기타"
    }
    println(result)

    when (getColor()) {
        Color.RED -> println("Red")
        Color.GREEN -> println("Green")
    }

    val number = 1
    when (number) {
        1, 2, 3 -> println("number 1,2,3")
        else -> println("else")
    }
}

enum class Color {
    RED, GREEN
}

fun getColor() = Color.RED
