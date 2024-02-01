package sample01

interface DB{
    fun save()
}
class SqliteDB: DB{
    override fun save() {
        println("save to sqlite")
    }
}
class MysqlDB: DB{
    override fun save() {
        println("save to mysql")
    }
}
/// 代理模式 把DbManager的save方法委托给DB省略了save方法的实现

class DBManager(db: DB): DB by db
/// 等同
class DBManager2(db: DB): DB {
    private val db: DB = db
    override fun save() {
        db.save()
    }
}


fun main() {
    DBManager(SqliteDB()).save()
    DBManager(MysqlDB()).save()
    DBManager2(SqliteDB()).save()
}