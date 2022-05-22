package com.example.datasource.journey.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.datasource.journey.bean.Higher;
import com.example.datasource.journey.bean.high_msg;
import com.example.datasource.journey.service.HigherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HigherController {

    @Autowired
    HigherService higherService;

    @GetMapping("/higher")
    public String Insert(){

        String json = "{\"reason\":\"success!\",\"result\":{\"updated_date\":\"2022-05-09 19:00:00\",\"high_count\":\"21\",\"middle_count\":\"79\",\"high_list\":[{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"双井街道\",\"area_name\":\"北京市 朝阳区 双井街道\",\"communitys\":[\"广和南里二条\"],\"county_code\":\"110105016\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"潘家园街道\",\"area_name\":\"北京市 朝阳区 潘家园街道\",\"communitys\":[\"松榆西里社区\",\"潘家园社区\"],\"county_code\":\"110105018\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"建外街道\",\"area_name\":\"北京市 朝阳区 建外街道\",\"communitys\":[\"北郎东社区\",\"南郎社区\"],\"county_code\":\"110105001\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"劲松街道\",\"area_name\":\"北京市 朝阳区 劲松街道\",\"communitys\":[\"农光东里社区\",\"农光里社区\"],\"county_code\":\"110105017\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"高碑店（地区）乡\",\"area_name\":\"北京市 朝阳区 高碑店（地区）乡\",\"communitys\":[\"方家园社区\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"十八里店（地区）乡\",\"area_name\":\"北京市 朝阳区 十八里店（地区）乡\",\"communitys\":[\"周家庄中路19号院\",\"吕家营村\",\"周家庄村\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"金盏（地区）乡\",\"area_name\":\"北京市 朝阳区 金盏（地区）乡\",\"communitys\":[\"金盏嘉园二社区\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"房山区\",\"county\":\"阎村镇\",\"area_name\":\"北京市 房山区 阎村镇\",\"communitys\":[\"大紫草坞村\"],\"county_code\":\"110111101\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"房山区\",\"county\":\"窦店镇\",\"area_name\":\"北京市 房山区 窦店镇\",\"communitys\":[\"于庄村\",\"燕都世界名园社区\",\"瓦窑头村\",\"一街村\"],\"county_code\":\"110111103\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"房山区\",\"county\":\"长阳镇\",\"area_name\":\"北京市 房山区 长阳镇\",\"communitys\":[\"加州水郡东区社区金桥国际公寓\"],\"county_code\":\"110111105\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"新华街道\",\"area_name\":\"北京市 通州区 新华街道\",\"communitys\":[\"盛业家园社区\",\"如意社区\"],\"county_code\":\"110112002\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"中仓街道\",\"area_name\":\"北京市 通州区 中仓街道\",\"communitys\":[\"新华园社区\"],\"county_code\":\"110112001\"}],\"middle_list\":[{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"双井街道\",\"area_name\":\"北京市 朝阳区 双井街道\",\"communitys\":[\"黄木厂社区\",\"和平村一社区\"],\"county_code\":\"110105016\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"垡头街道\",\"area_name\":\"北京市 朝阳区 垡头街道\",\"communitys\":[\"垡头西里社区\"],\"county_code\":\"110105019\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"八里庄街道\",\"area_name\":\"北京市 朝阳区 八里庄街道\",\"communitys\":[\"红庙北里社区\"],\"county_code\":\"110105015\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"潘家园街道\",\"area_name\":\"北京市 朝阳区 潘家园街道\",\"communitys\":[\"松榆里社区\",\"松榆东里社区\",\"武圣东里\"],\"county_code\":\"110105018\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"南磨房（地区）乡\",\"area_name\":\"北京市 朝阳区 南磨房（地区）乡\",\"communitys\":[\"南新园社区\",\"双龙南里\",\"双龙西社区\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"小红门（地区）乡\",\"area_name\":\"北京市 朝阳区 小红门（地区）乡\",\"communitys\":[\"鸿博家园第一社区\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"十八里店（地区）乡\",\"area_name\":\"北京市 朝阳区 十八里店（地区）乡\",\"communitys\":[\"弘善家园\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"朝阳区\",\"county\":\"豆各庄（地区）乡\",\"area_name\":\"北京市 朝阳区 豆各庄（地区）乡\",\"communitys\":[\"朝丰家园社区\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"房山区\",\"county\":\"阎村镇\",\"area_name\":\"北京市 房山区 阎村镇\",\"communitys\":[\"小紫草坞村\",\"张庄村\",\"乐活雅苑小区\"],\"county_code\":\"110111101\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"房山区\",\"county\":\"琉璃河（地区）镇\",\"area_name\":\"北京市 房山区 琉璃河（地区）镇\",\"communitys\":[\"兴礼村\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"房山区\",\"county\":\"窦店镇\",\"area_name\":\"北京市 房山区 窦店镇\",\"communitys\":[\"田家园村\",\"芦村\",\"下坡店村\",\"袁庄村\",\"沁园春景社区\",\"腾龙家园社区\",\"窦店产业园\"],\"county_code\":\"110111103\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"房山区\",\"county\":\"西潞街道\",\"area_name\":\"北京市 房山区 西潞街道\",\"communitys\":[\"苏庄三里社区\"],\"county_code\":\"110111012\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"永顺（地区）镇\",\"area_name\":\"北京市 通州区 永顺（地区）镇\",\"communitys\":[\"永顺西里社区\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"潞城镇\",\"area_name\":\"北京市 通州区 潞城镇\",\"communitys\":[\"后北营村\"],\"county_code\":\"110112119\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"梨园（地区）镇\",\"area_name\":\"北京市 通州区 梨园（地区）镇\",\"communitys\":[\"颐瑞西里社区\",\"大方居社区\"],\"county_code\":null},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"于家务回族乡\",\"area_name\":\"北京市 通州区 于家务回族乡\",\"communitys\":[\"西里社区\",\"聚福园开发区\"],\"county_code\":\"110112209\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"北苑街道\",\"area_name\":\"北京市 通州区 北苑街道\",\"communitys\":[\"官园社区\"],\"county_code\":\"110112003\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"玉桥街道\",\"area_name\":\"北京市 通州区 玉桥街道\",\"communitys\":[\"葛布店北里社区\"],\"county_code\":\"110112004\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"通运街道\",\"area_name\":\"北京市 通州区 通运街道\",\"communitys\":[\"通胡大街78号\"],\"county_code\":\"110112006\"},{\"type\":\"2\",\"province\":\"北京市\",\"city\":\"通州区\",\"county\":\"九棵树街道\",\"area_name\":\"北京市 通州区 九棵树街道\",\"communitys\":[\"翠景北里社区\"],\"county_code\":\"110112010\"},{\"type\":\"2\",\"province\":\"辽宁省\",\"city\":\"丹东市\",\"county\":\"振兴区\",\"area_name\":\"辽宁省 丹东市 振兴区\",\"communitys\":[\"知春园小区一期\",\"丹建锦园93号楼\",\"丹建锦园95号楼\",\"福临花园小区\",\"文安新村小区\",\"丹建馨园小区\",\"红房新区小区\",\"桃源逸景小区\"],\"county_code\":\"210603\"},{\"type\":\"2\",\"province\":\"辽宁省\",\"city\":\"营口市\",\"county\":\"大石桥市\",\"area_name\":\"辽宁省 营口市 大石桥市\",\"communitys\":[\"鑫盛家园\"],\"county_code\":\"210882\"},{\"type\":\"2\",\"province\":\"黑龙江省\",\"city\":\"哈尔滨市\",\"county\":\"南岗区\",\"area_name\":\"黑龙江省 哈尔滨市 南岗区\",\"communitys\":[\"鲁商凤凰城3栋\"],\"county_code\":\"230103\"},{\"type\":\"2\",\"province\":\"黑龙江省\",\"city\":\"哈尔滨市\",\"county\":\"松北区\",\"area_name\":\"黑龙江省 哈尔滨市 松北区\",\"communitys\":[\"浦江国际小区\"],\"county_code\":\"230109\"},{\"type\":\"2\",\"province\":\"黑龙江省\",\"city\":\"哈尔滨市\",\"county\":\"香坊区\",\"area_name\":\"黑龙江省 哈尔滨市 香坊区\",\"communitys\":[\"朝阳镇永胜村居民区\",\"朝阳镇平安村居民区\"],\"county_code\":\"230110\"},{\"type\":\"2\",\"province\":\"黑龙江省\",\"city\":\"哈尔滨市\",\"county\":\"宾县\",\"area_name\":\"黑龙江省 哈尔滨市 宾县\",\"communitys\":[\"宾州镇迎宾尚城1号高层\",\"宾州镇迎宾尚城3号高层\",\"宾安镇立新村李八仙屯\",\"宾州镇山水庭苑小区9号楼\",\"宾州镇盛鑫嘉园13号楼\",\"宾州镇盛鑫嘉园14号楼\",\"宾州镇鑫福家园高层\",\"宾州镇迎宾尚城A区1号楼\",\"宾州镇迎宾尚城A区2号楼\",\"宾州镇迎宾尚城A区3号楼\",\"宾州镇和泓山水阳光小区1期\",\"宾州镇天福缘新区\",\"宾州镇绿海家园小区\",\"宾州镇金穗小区\"],\"county_code\":\"230125\"},{\"type\":\"2\",\"province\":\"黑龙江省\",\"city\":\"牡丹江市\",\"county\":\"绥芬河市\",\"area_name\":\"黑龙江省 牡丹江市 绥芬河市\",\"communitys\":[\"源丰经贸公司\"],\"county_code\":\"231081\"},{\"type\":\"2\",\"province\":\"上海市\",\"city\":\"上海市\",\"county\":\"黄浦区\",\"area_name\":\"上海市 上海市 黄浦区\",\"communitys\":[\"打浦桥街道顺昌路612弄20号\"],\"county_code\":\"310101\"},{\"type\":\"2\",\"province\":\"上海市\",\"city\":\"上海市\",\"county\":\"闵行区\",\"area_name\":\"上海市 上海市 闵行区\",\"communitys\":[\"梅陇镇许泾村八组\",\"梅陇镇行南村三队\",\"华漕镇许浦村三队\"],\"county_code\":\"310112\"},{\"type\":\"2\",\"province\":\"上海市\",\"city\":\"上海市\",\"county\":\"嘉定区\",\"area_name\":\"上海市 上海市 嘉定区\",\"communitys\":[\"马陆镇康年路261号工地宿舍\",\"江桥镇增建村柴中村民组\"],\"county_code\":\"310114\"},{\"type\":\"2\",\"province\":\"上海市\",\"city\":\"上海市\",\"county\":\"浦东新区\",\"area_name\":\"上海市 上海市 浦东新区\",\"communitys\":[\"日京路88号\",\"北蔡镇联勤村冯桥南宅\",\"北蔡镇鹏飞路411弄6号\",\"康桥镇苗桥路935弄19号\",\"北蔡镇御北路235号\"],\"county_code\":\"310115\"},{\"type\":\"2\",\"province\":\"上海市\",\"city\":\"上海市\",\"county\":\"崇明区\",\"area_name\":\"上海市 上海市 崇明区\",\"communitys\":[\"长兴镇长明村21队\",\"长兴镇新港村15队\"],\"county_code\":\"310151\"},{\"type\":\"2\",\"province\":\"河南省\",\"city\":\"信阳市\",\"county\":\"固始县\",\"area_name\":\"河南省 信阳市 固始县\",\"communitys\":[\"石佛店镇漂桥村\",\"张广庙镇龙井村\"],\"county_code\":\"411525\"},{\"type\":\"2\",\"province\":\"广东省\",\"city\":\"湛江市\",\"county\":\"坡头区\",\"area_name\":\"广东省 湛江市 坡头区\",\"communitys\":[\"官渡镇工业园工业大道北湛江市巾帼仓储有限公司\"],\"county_code\":\"440804\"}]},\"error_code\":0}\n";

        JSONObject jsonObject = JSON.parseObject(json);

        Object result = jsonObject.get("result");

        String s = "[" + result.toString() + "]";

        List<high_msg> high_msgs = JSON.parseArray(s, high_msg.class);

        for(high_msg high : high_msgs){
            int high_count = high.getHigh_count();
            int middle_count = high.getMiddle_count();
            String updated_date = high.getUpdated_date();


            for(Higher higher : high.getHigh_list()){
                List<String> communitys = higher.getCommunitys();
                String city = higher.getCity();
                String area_name = higher.getArea_name();
                String county = higher.getCounty();
                int county_code = higher.getCounty_code();
                String province = higher.getProvince();
                int type = higher.getType();
                higherService.InsertHighList(area_name,province,city,county_code,county,type);
                for(String community : communitys){
                    higherService.InsertCommunity(area_name,community);
                }
            }

            for(Higher middler : high.getMiddle_list()){
                String city = middler.getCity();
                List<String> communitys = middler.getCommunitys();
                String county = middler.getCounty();
                String province = middler.getProvince();
                int type = middler.getType();
                int county_code = middler.getCounty_code();
                String area_name = middler.getArea_name();
                higherService.InsertMiddleList(area_name,province,city,county_code,county,type);
                for(String community : communitys){
                    higherService.InsertCommunity(area_name,community);
                }
            }
        }
        higherService.InsertHighMsg(high_msgs.get(0).getUpdated_date(),high_msgs.get(0).getHigh_count(),high_msgs.get(0).getMiddle_count());
        return "successful";
    }

}
