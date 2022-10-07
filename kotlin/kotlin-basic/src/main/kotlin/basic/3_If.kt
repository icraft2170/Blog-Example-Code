package basic

fun main() {
    // if...else
    var job = "Software Developer"

    if (job == "Software Developer") {
        println("개발자")
    } else {
        println("개발자 아님")
    }
    /**
     * 코틀린의 if-else 는 표현식이다 따라서 값을 반환할 수 있다.
     * 때문에 삼함연산자가 존재하지 않는다.
     */
    var age = 10

    val level = if (age > 19) {
        "성인"
    } else {
        "청소년"
    }

    print(level)



}