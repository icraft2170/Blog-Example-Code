package advanced.dataclass

data class Person(val name: String, val age: Int)

fun main() {
    val person1 = Person("Hero", 26)
    val person2 = Person("Hero", 26)
    println(person1 == person2)  //true
    println(person1.equals(person2))  //true
    println("${person1.hashCode()}  ${person2.hashCode()}" ) // 같음
    println("${person1.component1()}  ${person1.component2()}" ) // 같음

    val set = hashSetOf(person1)
    println(set.contains(person2)) //true

    val chad1 = person1.copy(name = "Chad", age = 26)
    val chad2 = person2.copy(name = "Chad", age = 26)

    println(chad1 == chad2)  //true
    println(chad1.equals(chad2))  //true
    println("${chad1.hashCode()}  ${chad2.hashCode()}" ) // 같음
    val (name, age) = chad2 // 구조분해 할당
    println("${name} ${age}")
}