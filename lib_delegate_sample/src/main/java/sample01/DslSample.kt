package sample01



//1.需要讓layout 的方法實作都可以操作自身物件 this  所以action 使用擴展方法
fun <T> layout( action:T.()->Unit){
}
//2.讓action 可以擴展更多方法
//此時的 T 會是layout 的物件類型
fun <T> T.button(action:T.()->Unit){
}
fun <T> T.text(action:T.()->Unit){

}

fun main(){
  //1. 定義 物件類型
  // 這裡的類型一定要傳因為沒有型態則無法用泛型繼續擴展方法
  //需要讓layout 的方法實作都可以操作自身物件 this
  layout<String>{
      button{}
      text{}
  }
}