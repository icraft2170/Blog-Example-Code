package basic

fun main() {
    val b : String? = null
    val c : String = b ?: failFast("a is null")

    println(c)
}

fun failFast(message : String) : Nothing{
    throw IllegalArgumentException()
}