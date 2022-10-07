package advanced

sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        print("저는 백엔드 개발자입니다 ${language} 를 사용합니다.")
    }
}


class FrontEndDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        print("저는 프론트엔드 개발자입니다 ${language} 를 사용합니다.")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()
    fun add(developer: Developer) = when(developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontEndDeveloper -> pool[developer.name] = developer
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "토니")
    DeveloperPool.add(backendDeveloper)

    val frontEndDeveloper = FrontEndDeveloper(name = "히로")
    DeveloperPool.add(frontEndDeveloper)

    println("백엔드 이름 ${DeveloperPool.get("토니")?.name}")
    println("프론트엔드 이름 ${DeveloperPool.get("히로")?.name}")
}