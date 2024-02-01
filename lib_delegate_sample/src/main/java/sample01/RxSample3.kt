package sample01


// 用來傳遞結果
class ResultCache<T> (  var data:T)

fun <R> create (action:()->R) = ResultCache(action())
// 必須讓action 可以直接調用data
//所以要讓實作可以拿到並操作data
// 這裡使用拓展函數 action:T.()->R
// 因為擴展ResultCache 可以直接拿到data

fun <T,R> ResultCache<T>.map(action:T.()->R) = ResultCache(action(data))
fun <T> ResultCache<T>.consume(action:T.()->Unit) = action(data)
fun main() {

    create { "test" }
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
        }

}
