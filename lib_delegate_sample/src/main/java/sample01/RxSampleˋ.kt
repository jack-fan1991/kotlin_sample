package sample04


// 直接回傳action 的返回類型
fun <R> create (action:()->R) = action()
// 以上一層的返回類型作為擴展並在action 中使用擴展方法直接操作上一層的物件
fun <T,R> T.map(action:T.()->R) = action(this)
fun <T> T.consume(action:T.()->Unit) = action(this)
fun main() {
    create { "test2" }
        .map {
            this.length
            // this 可以省略直接調用
            length

            println(this)
            123
        }.map {
            println(this)
            456
        }

        .consume {
            println(this)
        }.apply {  }

}
