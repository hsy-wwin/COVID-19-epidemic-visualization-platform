package util

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}

import org.apache.kafka.common.TopicPartition
import org.apache.spark.streaming.kafka010.OffsetRange

import scala.collection.mutable

/**
 * Author itcast
 * Date 2020/5/28 11:36
 * Desc 用来手动维护偏移量到MySQL中的工具类
 */
object OffsetUtils {
  /**
   * 根据参数查询偏移量信息并封装成Map返回
   * @param groupId 消费者组名称
   * @param topic 主题
   * @return 偏移量信息封装成的Map
   */
  def getOffsetsMap(groupId: String, topic: String): mutable.Map[TopicPartition, Long] = {
    //1.获取连接
    val conn: Connection = DriverManager.getConnection("jdbc:mysql://43.138.166.220:3306/bigdata?useUnicode=true&useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useAffectedRows=true&allowMultiQueries=true","root","123456")
    //2.编写sql
    val sql:String = "select partid,offset from t_offset where groupid = ? and topic = ?"
    //3.获取ps
    val ps: PreparedStatement = conn.prepareStatement(sql)
    //4.设置参数并执行
    ps.setString(1,groupId)
    ps.setString(2,topic)
    val rs: ResultSet = ps.executeQuery()
    //5.获取返回值并封装成Map
    val offsetsMap:mutable.Map[TopicPartition, Long] = mutable.Map[TopicPartition, Long]()
    while(rs.next()){
      val partition: Int = rs.getInt("partid")
      val offset: Int = rs.getInt("offset")
      offsetsMap += new TopicPartition(topic,partition) -> offset
    }

    //6.关闭资源
    rs.close()
    ps.close()
    conn.close()
    //7.返回Map
    offsetsMap
  }

  /**
   * 将消费者组的偏移量信息存入到MySQL
   *
   * @param groupId 消费者组名称
   * @param offsets 偏移量信息
   * CREATE TABLE `t_offset` (
   * `topic` varchar(255) NOT NULL,
   * `partition` int(11) NOT NULL,
   * `groupid` varchar(255) NOT NULL,
   * `offset` bigint(20) DEFAULT NULL,
   * PRIMARY KEY (`topic`,`partition`,`groupid`)
   * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
   */
  def saveOffsets(groupId: String, offsets: Array[OffsetRange]) = {
    //1.加载驱动并获取连接
    val conn: Connection = DriverManager.getConnection("jdbc:mysql://43.138.166.220:3306/bigdata?useUnicode=true&useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useAffectedRows=true&allowMultiQueries=true","root","123456")
    //2.编写sql
    val sql:String = "replace into t_offset (topic,partid,groupid,offset) values(?,?,?,?)"
    //3.创建预编译语句对象
    val ps: PreparedStatement = conn.prepareStatement(sql)
    //4.设置参数并执行
    for (o<-offsets){
      ps.setString(1,o.topic)
      ps.setInt(2,o.partition)
      ps.setString(3,groupId)
      ps.setLong(4,o.untilOffset)
      ps.executeUpdate()
    }
    //5.关闭资源
    ps.close()
    conn.close()
  }
}
