package basic
class Product(val name: String, val price: Int)
interface Cart {
    var coin :Int;

    // var로 생성 불가 (변경이 불가하게 생성해야하는 것으로 보임)
    // 이유로는 다이나믹 프록시에 `weight` 에 getter 를 static 으로 구현하고 연결한것으로 보인다.
    // 사실은 필드는 존재하지 않고 `getter`만 존재하는 것
    val weight : String
        get() = "20KG"

    fun add(product: Product)

    fun rent() {
        println("Dynamic Proxy Object 이용 Method")
        /**
         * 상속 불가능한 final Class 하위타입을 만들고 그곳에 Default Method를 Static으로 구현해둔다.
         */
    }
}

class MyCart : Cart {
    override var coin: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun add(product: Product) {
        TODO("Not yet implemented")
    }

    override fun rent() {
        super.rent()
    }
}