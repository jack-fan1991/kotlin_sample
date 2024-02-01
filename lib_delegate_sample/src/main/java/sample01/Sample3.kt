package sample01

class Sample3 {
    // 需求: 始能內部操作禁止外部操作
    // 建立不可修改的list 提供外部調用
    val data :List<String> by:: _data
    private val _data = mutableListOf<String>()

    fun updateData(){
        _data.add("test")
    }

}

class Person {
    var name: String = ""
    var age: Int = 0
    var address: String = ""
}

fun main() {
    // 使用 run 進行多段操作
    val finalPerson = Person().run {
        // 第一段操作：初始化 name 屬性
        apply {
            name = "John"
        }
        // 第二段操作：初始化 age 屬性
        run {
            age = 30
            // 返回一個新的 Person 對象
            Person()
        }
        // 第三段操作：初始化 address 屬性
        also {
            it.address = "123 Main St"
        }
    }

    // 印出最終初始化後的屬性值
    println("Name: ${finalPerson.name}, Age: ${finalPerson.age}, Address: ${finalPerson.address}")
}

fun <T> T.countMatches(predicate: (T) -> Boolean): Int {
    return if (predicate(this)) 1 else 0
}
