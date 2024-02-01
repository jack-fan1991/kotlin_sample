package sample01

class ClickListener<T> {
    // 可以把lambda當成參數傳入
    // 不用再傳入接口的實作

    private val actions = mutableListOf<(T?) -> Unit>()
    private val params = mutableListOf<T?>()

    fun addListener(param:T?, action: (T?) -> Unit) {
        actions += action
        params.add(param)

    }

    fun click() {
        if (actions.size != params.size) {
            throw Exception("actions size != params size")
        }
        if (actions.isEmpty()) {
            throw Exception("actions is empty")
        }
        actions.forEachIndexed{ index, action ->
            action .invoke(params[index])
        }

    }

}

fun main() {
    val clickListener = ClickListener<String>()
    clickListener.addListener("test") {
        println("test1 $it")
    }
    clickListener.addListener("test2") {
        println("test2 $it")
    }
    // 動態回調
    val hasNameAction : (Any?)->Unit = {
        println("hasName $it")
    }
    // 匿名函數作為傳遞

    clickListener.addListener("noName",::noNameAction)
    // 傳入方法變數
    clickListener.addListener("hasName",hasNameAction)


    clickListener.click()
}

fun <T> noNameAction (param: T? ):Unit {
    println("noNameAction $param")
}