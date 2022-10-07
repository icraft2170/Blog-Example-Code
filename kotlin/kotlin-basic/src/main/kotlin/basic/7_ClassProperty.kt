package basic

//class Coffee constructor(val name: String){}

abstract class Dog{
    abstract var age : Int
    open fun bark() {
        print("멍멍")
    }
}
//
class BullDog(override var age: Int = 1) : Dog() {
    override fun bark() {
        print("컹컹")
    }
}

fun main() {
    val bullDog = BullDog()
    bullDog.bark()
}

