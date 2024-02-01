
| Kotlin | Java |
| ------ | ---- |
| Unit   | void |

* 方法宣告

``` kotlin
  val 變數 :(參數) -> 回傳值
```

``` kotlin
    // Java 
    public void method01(){}
    public void method02(int a, int b){}
    public Object method03(String a, double b){}

    // lambda
    val method01:()-> Unit
    val method02 : (Int, Int) -> Unit
    val method03 : (String,Double) -> Any

```

* 方法實作

``` kotlin
  val 變數 :{(參數) -> 方法實作}
```

``` kotlin
    // Java 
    public void method01(){
        System.out.println("method01")
    }
    // 自動推斷類型可不寫
    val method01:()-> Unit = {println("method01")}
    val method01={println("method01")}
    method01()
    method01.invoke()

```
* 自動回傳最後一行


``` kotlin
    // Java 
    public String method01(){
      return "method01"
    }
    // 自動推斷類型可不寫
    val method01 :()-> String = {"method01"}
    val method01 = {"method01"}
```

* 參數接收


``` kotlin
    // Java 
    public void method01(String str){
        System.out.println(str)
    }
    // 自動推斷類型可不寫
    val method01 :(String)-> Unit = {str -> println(str)}
    val method01 = {str:String -> println(str)}
    method01("method01")
```

#### lambda 擴展匿名函數

* 使用擴展方法直接操作物件
* 輸入解析
``` kotlin
   val callMyself:String.()-> Unit = {println(this)}
   "method01".callMyself()
   // 單一參數自動判斷it
   val add : Int.(Int)-> Int = { this + it }
    println(1.add(2))
    println(add(1,2))
   
   // 多參數自動判斷必須手動解析
    val add : Int.(Int,Int)-> Int = { a,b -> this + a + b }
    println(1.add(2,3))

```

* 回傳解析
``` kotlin
fun t01() { println("t01") } //return Unit
fun t02() {123.5f} //return Unit
fun t03():Float {return 123.5f} //return Float 指定回
fun t03() {return 123.5f}// return Float動態判斷回傳

fun s01() = { } //return Unit 方法回傳方法
fun s01():()-> Unit = { } //return Unit 方法回傳方法
s01()() //執行方法回傳方法

// run
// run 會回傳該函數的回傳值ＦＦ
fun s02() = run { 123.5f } //return Float 方法回傳方法
fun s03():()-> Float = { true} //return Float 方法回傳方法
s02() //123.5f 
s03()() //true

// s01() 返回{} 的返回值預設為Unit
// s02() 返回run{} 的返回值為123.5f
// s03() 返回()-> Float 此為一個方法,需要在調用一次 , 返回值為true
```
```