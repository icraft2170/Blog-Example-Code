package advanced.collection

import java.util.LinkedList

fun main() {
    //immutable list
    val currencyList = listOf("달러", "원", "유로")

    //mutable list
    val mutableCurrencyList = mutableListOf<String>()
    mutableCurrencyList.add("달러")
    mutableCurrencyList.add("원")
    mutableCurrencyList.add("유로")

    //
    val mutableCurrencyList2 = mutableListOf<String>()
    .apply {
         this.add("달러")
         this.add("원")
         this.add("유로")
    }

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }


    // immutable map (중위 표현식 to )
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)

    // mutable map
    val mutableMap = mutableMapOf<String, Int>()
    mutableMap["one"] = 1
    mutableMap["two"] = 2
    mutableMap["three"] = 3


    // 컬렉션 빌더
    val numberList: List<Int> = buildList{
        add(1)
        add(2)
        add(3)
    }

    //linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(1)
        add(2)
        addLast(5)
    }

    // ArrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
    }


    // Iterator
    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }
    println("==============================")

    // for-in
    for (currency in currencyList) {
        println(currency)
    }
    println("==============================")
    currencyList.forEach {
        println(it)
    }
    println("==============================")
    val lowerList = listOf<String>("a", "b", "c")
    val upperList = mutableListOf<String>()

    for (lowerCase in lowerList) {
        upperList.add(lowerCase.uppercase())
    }
    println(upperList)

    val upperList2 = lowerList.map { it.uppercase() }
    println(upperList2)
    println("==============================")
    val filteredList = mutableListOf<String>("a", "b", "c")
    val upperList3 = filteredList
        .filter { it == "a" || it == "c" }
        .map { it.uppercase() }
    println(upperList3)
    println("==============================")
    val sequenceList = mutableListOf<String>("a", "b", "c")
    val upperList4 = sequenceList
        .asSequence()
        .filter { it == "a" || it == "c" }
        .filter { it == "d" || it == "e" }
        .filter { it == "d" || it == "e" }
        .filter { it == "d" || it == "b" }
        .map { it.uppercase() }
        .toList()
    println(upperList4)


}