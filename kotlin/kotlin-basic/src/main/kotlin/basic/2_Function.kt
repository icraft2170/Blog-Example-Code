package basic

// 기본적인 선언 방법
fun sum(a: Int, b: Int): Int {
    return a + b
}
// 반환 타입 생략시 컴파일 에러
//fun sum1(a: Int, b: Int) {
//    return a + b
//}

//표현식 스타일의 선언 방법
fun sum2(a: Int, b: Int): Int = a + b

//표현식 스타일의 선언 방법 & 반환 타입 생략
fun sum3(a: Int, b: Int) = a + b

// void => Unit
// 코틀린은 반환 타입이 없을 때 Unit을 반환한다.
fun printSum(a: Int, b: Int) {
    println("$a + $b = ${a + b}")
}

// 디폴트 파라미터
fun greeting(message :String = "안녕하세요!") {
    println(message)
}
//
//fun main() {
//    greeting()
//    greeting("HI~~!")
//}


// 네임드 아규먼
fun log(level :String = "INFO", message: String) {
    println("[$level]$message")
}

fun main() {
    log(message = "인포로그")
    log(level = "DEBUG", "디버그 로그")
    log("WARN", "워닝 로그")
    log(level = "ERROR", message = "에러 로그")
}
