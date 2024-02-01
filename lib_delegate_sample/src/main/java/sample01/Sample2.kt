package sample01

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/// 成員委託範例
class A{
    var version: String = "test"
    var version2 : String by ::version// 委託給version會掉用相同的get setter
}


/// 自定義委託範例
///
class RefClass{
    var version: String by Delegate()
}

/// example1
class Delegate{
    // 使用反射查找第一個必須找到成員所屬的淚名稱 ＝> RefClass
    operator fun getValue(refClass: RefClass, property: KProperty<*>): String {
        return "version: ${property.name}"
    }
    operator fun setValue(refClass: RefClass, property: KProperty<*>, value: String) {
        println("$value is assigned to ${property.name} in $refClass")
    }
}

// example2 使用標準庫的委託
class StringDelegate : ReadWriteProperty<RefClass,String> {
    override fun getValue(thisRef: RefClass, property: KProperty<*>): String {
        TODO("Not yet implemented")
    }

    override fun setValue(thisRef: RefClass, property: KProperty<*>, value: String) {
        TODO("Not yet implemented")
    }
}

/// example3
class StringDelegate2 : ReadOnlyProperty<RefClass, String> {
    private var value: String = ""
    override fun getValue(thisRef: RefClass, property: KProperty<*>): String {
        return value
    }


}