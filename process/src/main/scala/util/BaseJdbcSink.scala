package util

import org.apache.spark.sql.{ForeachWriter, Row}

import java.sql.{Connection, DriverManager, PreparedStatement}


abstract class BaseJdbcSink(sql: String) extends ForeachWriter[Row] {
  def realProcess(str: String, row: Row)

  var conn: Connection = _
  var ps: PreparedStatement = _

  //开启连接
  override def open(partitionId: Long, version: Long): Boolean = {
    conn = DriverManager.getConnection("jdbc:mysql://43.138.166.220:3306/bigdata?useUnicode=true&useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useAffectedRows=true&allowMultiQueries=true","root","123456")
    true
  }

  //处理数据--将数据存入到MySQL
  override def process(value: Row): Unit = {
      realProcess(sql,value)
  }

  //关闭连接
  override def close(errorOrNull: Throwable): Unit = {
    if (conn != null) {
      conn.close()
    }
    if (ps != null) {
      ps.close()
    }
  }
}
