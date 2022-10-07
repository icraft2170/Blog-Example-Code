package basic

fun main() {
    val number1 : String? = null
//    println(number1.length)

    val number2 : Int = if (number1 != null) number1.length else 0
    println(number2)

    //엘비스 연산자(?:) - 가수 엘비스 프레슬리의 구렛나루를 닮았다 하여 엘비스 연산자라 부른다.

    val number3 : Int = number1?.length ?: throw RuntimeException();
    println(number3)
//
//    val c : String? = null
//    val d = c!!.length
//    println(d)
}