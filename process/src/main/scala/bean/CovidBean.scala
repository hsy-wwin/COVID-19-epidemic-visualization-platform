package bean

/**
 * Author itcast
 * Date 2020/5/28 17:26
 * Desc 
 */
case class CovidBean(
                      provinceName: String, //省份名称
                      provinceShortName: String, //省份短名
                      cityName: String,
                      currentConfirmedCount: Int, //当前确诊人数
                      confirmedCount: Int, //累计确诊人数
                      suspectedCount: Int, //疑似病例人数
                      curedCount: Int, //治愈人数
                      deadCount: Int, //死亡人数
                      locationId: Int, //位置id
                      pid: Int,
                      statisticsData: String, //每一天的统计数据
                      cities: String, //下属城市
                      datetime: String
                    )
