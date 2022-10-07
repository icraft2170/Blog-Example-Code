package advanced.singleton
//object Singleton {
//    var a = 1234
//    fun printA() { println(a) }
//}
//
//fun main() {
//    println(Singleton.a)
//    Singleton.printA()
//}

class MyClass private constructor() {
    companion object {
        val a = 1234
        fun newInstance() = MyClass()
    }
}

fun main() {
    println(MyClass.a)
    println(MyClass.newInstance())

    println(MyClass.Companion.a)
    println(MyClass.Companion.newInstance())
}