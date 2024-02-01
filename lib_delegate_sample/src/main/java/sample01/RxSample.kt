package sample01

class RxSample {
}

// 用來傳遞結果
class ResultCache<T>(private var data: T) {


    // 寫在此類中可以確保  ResultCache 物件也可以以鏈式掉用掉用方法傳遞 cache
    fun <R> map(action: (T) -> R): ResultCache<R> {
        //執行action return R
        val result: R = action(data)
        // 將結果保存cache並返回
        return ResultCache<R>(result)
    }

    // 寫在此類中可以確保  ResultCache 物件也可以以鏈式掉用掉用方法傳遞 cache
    fun <R> ezMap(action: (T) -> R): ResultCache<R> = ResultCache<R>(action(this.data))

    // 處理的終點不再回傳
    fun consume(action: (T) -> Unit) {
        action(data)
    }
}

fun <R> create(action: () -> R): ResultCache<R> {
    //執行action
    val result = action()
    // 將結果保存cache並返回
    // 將ResultCache 資料類型定義為action的返回類型 R
    return ResultCache<R>(result)
}

fun main() {

    create { "test" }
        .map {
            it.length
            println(it)
            123
        }.map {
            println(it)
            456
        }.consume {
            println(it)
        }

}


