package com.yilianyun.print.common;

import com.alibaba.fastjson.JSONObject;

/**
 * 提供json来转换模板，返回stringBuffer字符串
 * pzj 2020/12/22
 */
public class PrintTemplate {

    /**
     * 模板1 --预结单
     * @param jsonObject
     * @return
     */
    public static String template1(JSONObject jsonObject){

        StringBuffer sbf = new StringBuffer("<MS>0,0</MS>");//设置音量和音效

        sbf.append("<FS2><center>自 己 人 家 宴</center></FS2>\r\n");
        sbf.append("<FS2><center>**君子广场店**</center></FS2>\r\n");

        sbf.append("@@2开单时间：2020-12-21 13:10:03\n");
        sbf.append("@@2流水号：000016428\t\t\t营销经理：测试用\n");
        sbf.append("@@2单号：08073/1\t\t\t\t服务专员：周文娟\n");//17
        sbf.append("@@2桌号：08台\t\t\t\t\t人数：3\n");

        sbf.append("@@2================================================\n");

        sbf.append("<FH><FB><table>");//菜品列表开始
        sbf.append("<tr><td>茶位费(赠)</td><td>4 位</td><td>0.00</td></tr>");
        sbf.append("<tr><td>古法马拉糕18.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>家宴虾饺皇28.8元</td><td>1 </td><td>0.80</td></tr>");
        sbf.append("<tr><td>红烧乳鸽48元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>天鹅榴莲酥25.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>白灼黄秋葵18.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>套餐价148元</td><td>1 </td><td>148.00</td></tr>");
        sbf.append("<tr><td>皮蛋瘦肉粥18.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>好味酱凤爪25.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>秘制紫薯包（18.8）</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>*招牌炆羊腩</td><td>1 例</td><td>288.00</td></tr>");
        sbf.append("<tr><td>牛肋骨</td><td>1 半条</td><td>134.00</td></tr>");
        sbf.append("<tr><td>清蒸老虎斑（粤）</td><td>1.8 斤</td><td>428.40</td></tr>");
        sbf.append("<tr><td>茼蒿（*蒜蓉炒）</td><td>1 例</td><td>68.00</td></tr>");
        sbf.append("<tr><td>纸巾</td><td>1 盒</td><td>5.00</td></tr>");
        sbf.append("<tr><td>打包盒</td><td>4 个</td><td>4.00</td></tr>");
        sbf.append("</table></FB></FH>");//菜品列表结束

        sbf.append("@@2================================================\n");

        sbf.append("<FH><FB><table>");//金额列表开始
        sbf.append("<tr><td>小计：</td><td></td><td>1075.40</td></tr>");
        sbf.append("<tr><td>抹零：</td><td></td><td>-0.40</td></tr>");
        sbf.append("<tr><td>10%服务费：</td><td></td><td>92.00</td></tr>");
        sbf.append("<tr><td>美团套餐(148)：</td><td></td><td>148.00</td></tr>");
        sbf.append("<tr><td>应付：</td><td></td><td>1019.00</td></tr>");
        sbf.append("</table></FB></FH>");//金额列表结束

        sbf.append("\n");//换个行控制间隔

        sbf.append("@@2【未付款】\n");
        sbf.append("@@2打印时间：2020-12-21 15:56:49\n");
        sbf.append("@@2打印次数：1\n");

        //下面基本不动
        sbf.append("@@2                   谢谢光临！\n");
        sbf.append("@@2      深圳市福田区侨香路3076号君子广场一楼\n");
        sbf.append("@@2              电话：<FB>0755-8255 3188</FB>\n");
        sbf.append("@@2           如需开发票，请在<FB>30</FB>天之内开出！\n");

        sbf.append("\n");//换个行控制间隔
        //打印二维码
        sbf.append("<QR>测试数据</QR>");

        return sbf.toString();
    }

    /**
     * 模板2 --买单
     * @param jsonObject
     * @return
     */
    public static String template2(JSONObject jsonObject){

        StringBuffer sbf = new StringBuffer("<MS>0,0</MS>");//设置音量和音效

        sbf.append("<FS2><center>自 己 人 家 宴</center></FS2>\r\n");
        sbf.append("<FS2><center>**君子广场店**</center></FS2>\r\n");

        sbf.append("@@2开单时间：2020-12-21 13:10:03\n");
        sbf.append("@@2流水号：000016428\n");
        sbf.append("@@2单号：08073/1\t\t\t\t收银：周文娟\n");
        sbf.append("@@2桌号：08台\t\t\t\t\t人数：3\n");

        sbf.append("@@2================================================\n");

        sbf.append("<FH><FB><table>");//金额列表开始
        sbf.append("<tr><td>名称</td><td>数量</td><td>金额</td></tr>");
        sbf.append("</table></FB></FH>");//金额列表结束

        sbf.append("@@2------------------------------------------------\n");

        sbf.append("<FH><FB><table>");//菜品列表开始
        sbf.append("<tr><td>茶位费(赠)</td><td>4 位</td><td>0.00</td></tr>");
        sbf.append("<tr><td>古法马拉糕18.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>家宴虾饺皇28.8元</td><td>1 </td><td>0.80</td></tr>");
        sbf.append("<tr><td>红烧乳鸽48元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>天鹅榴莲酥25.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>白灼黄秋葵18.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>套餐价148元</td><td>1 </td><td>148.00</td></tr>");
        sbf.append("<tr><td>皮蛋瘦肉粥18.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>好味酱凤爪25.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>秘制紫薯包（18.8）</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>*招牌炆羊腩</td><td>1 例</td><td>288.00</td></tr>");
        sbf.append("<tr><td>牛肋骨</td><td>1 半条</td><td>134.00</td></tr>");
        sbf.append("<tr><td>清蒸老虎斑（粤）</td><td>1.8 斤</td><td>428.40</td></tr>");
        sbf.append("<tr><td>茼蒿（*蒜蓉炒）</td><td>1 例</td><td>68.00</td></tr>");
        sbf.append("<tr><td>纸巾</td><td>1 盒</td><td>5.00</td></tr>");
        sbf.append("<tr><td>打包盒</td><td>4 个</td><td>4.00</td></tr>");
        sbf.append("</table></FB></FH>");//菜品列表结束

        sbf.append("@@2================================================\n");

        sbf.append("<FH><FB><table>");//金额列表开始
        sbf.append("<tr><td>10%服务费：</td><td>63.00</td></tr>");
        sbf.append("<tr><td>应付金额：</td><td>696.00</td></tr>");
        sbf.append("</table></FB></FH>");//金额列表结束

        sbf.append("\n");//换个行控制间隔

        sbf.append("@@22020-12-21 15:56:49\t第1次打印\n");

        sbf.append("\n");//换个行控制间隔

        //下面基本不动
        sbf.append("@@2                   谢谢光临！\n");
        sbf.append("@@2      深圳市福田区侨香路3076号君子广场一楼\n");
        sbf.append("@@2              电话：<FB>0755-8255 3188</FB>\n");
        sbf.append("@@2           如需开发票，请在<FB>30</FB>天之内开出！\n");

        sbf.append("\n");//换个行控制间隔
        //打印二维码
        sbf.append("<QR>测试数据</QR>");

        return sbf.toString();
    }

    /**
     * 模板3 --vip签单
     * @param jsonObject
     * @return
     */
    public static String template3(JSONObject jsonObject){

        StringBuffer sbf = new StringBuffer("<MS>0,0</MS>");//设置音量和音效

        sbf.append("<FS2><center>自 己 人 家 宴</center></FS2>\r\n");
        sbf.append("<FS2><center>**君子广场店**</center></FS2>\r\n");

        sbf.append("@@2开单时间：2020-12-21 13:10:03\n");
        //sbf.append("@@2流水号：000016428\n");
        sbf.append("@@2单号：08073/1\t\t\t\t收银：周文娟\n");//17
        sbf.append("@@2桌号：08台\t\t\t\t\t人数：3\n");

        sbf.append("@@2================================================\n");

        sbf.append("<FH><FB><table>");//表头开始
        sbf.append("<tr><td>名称</td><td>数量</td><td>金额</td></tr>");
        sbf.append("</table></FB></FH>");//表头结束

        sbf.append("@@2------------------------------------------------\n");

        sbf.append("<FH><FB><table>");//菜品列表开始
        sbf.append("<tr><td>茶位费(赠)</td><td>4 位</td><td>0.00</td></tr>");
        sbf.append("<tr><td>古法马拉糕18.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>家宴虾饺皇28.8元</td><td>1 </td><td>0.80</td></tr>");
        sbf.append("<tr><td>红烧乳鸽48元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>天鹅榴莲酥25.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>白灼黄秋葵18.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>套餐价148元</td><td>1 </td><td>148.00</td></tr>");
        sbf.append("<tr><td>皮蛋瘦肉粥18.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>好味酱凤爪25.8元</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>秘制紫薯包（18.8）</td><td>1 </td><td>0.00</td></tr>");
        sbf.append("<tr><td>*招牌炆羊腩</td><td>1 例</td><td>288.00</td></tr>");
        sbf.append("<tr><td>牛肋骨</td><td>1 半条</td><td>134.00</td></tr>");
        sbf.append("<tr><td>清蒸老虎斑（粤）</td><td>1.8 斤</td><td>428.40</td></tr>");
        sbf.append("<tr><td>茼蒿（*蒜蓉炒）</td><td>1 例</td><td>68.00</td></tr>");
        sbf.append("<tr><td>纸巾</td><td>1 盒</td><td>5.00</td></tr>");
        sbf.append("<tr><td>打包盒</td><td>4 个</td><td>4.00</td></tr>");
        sbf.append("</table></FB></FH>");//菜品列表结束

        sbf.append("@@2================================================\n");

        sbf.append("<FH><FB><table>");//金额列表开始
        sbf.append("<tr><td>全单8.8折：</td><td></td><td>-45.00</td></tr>");
        sbf.append("<tr><td>抹零：</td><td></td><td>-0.40</td></tr>");
        sbf.append("<tr><td>10%服务费：全免</td><td></td><td>0.00</td></tr>");
        sbf.append("<tr><td>签单：张老师：</td><td></td><td>335.00</td></tr>");
        sbf.append("<tr><td>应付金额：</td><td></td><td>335.00</td></tr>");
        sbf.append("</table></FB></FH>");//金额列表结束

        sbf.append("\n");//换个行控制间隔

        sbf.append("@@22020-12-21 15:56:49\t第2次打印\n");

        sbf.append("\n");//换个行控制间隔

        //下面基本不动
        sbf.append("@@2                   谢谢光临！\n");
        sbf.append("@@2      深圳市福田区侨香路3076号君子广场一楼\n");
        sbf.append("@@2              电话：<FB>0755-8255 3188</FB>\n");
        sbf.append("@@2           如需开发票，请在<FB>30</FB>天之内开出！\n");

        sbf.append("\n");//换个行控制间隔

        //打印二维码
        sbf.append("<QR>测试数据</QR>");

        return sbf.toString();
    }

    /**
     * 模板4---预存
     * @param jsonObject
     * @return
     */
    public static String template4(JSONObject jsonObject){

        StringBuffer sbf = new StringBuffer("<MS>0,0</MS>");//设置音量和音效

        sbf.append("<FS2><center>自 己 人 家 宴</center></FS2>\r\n");
        sbf.append("<FS2><center>**君子广场店**</center></FS2>\r\n");

        sbf.append("@@2开单时间：2020-12-21 13:10:03\n");
        //sbf.append("@@2流水号：000016428\n");
        sbf.append("@@2单号：08073/1\t\t\t\t收银：周文娟\n");//17
        sbf.append("@@2桌号：08台\t\t\t\t\t人数：3\n");

        sbf.append("@@2================================================\n");

        sbf.append("<FH><FB><table>");//表头开始
        sbf.append("<tr><td>名称</td><td>数量</td><td>金额</td></tr>");
        sbf.append("</table></FB></FH>");//表头结束

        sbf.append("@@2------------------------------------------------\n");

        sbf.append("<FH><FB><table>");//菜品列表开始
        sbf.append("<tr><td>茶位费(赠)</td><td>6 位</td><td>48.00</td></tr>");
        sbf.append("<tr><td>橄榄瘦肉汤</td><td>6 位</td><td>408.00</td></tr>");
        sbf.append("<tr><td>清蒸老虎斑（粤）</td><td>1.8 斤</td><td>428.40</td></tr>");
        sbf.append("<tr><td>蒜蓉蒸大花虾</td><td>1 斤</td><td>298.00</td></tr>");
        sbf.append("<tr><td>柠檬</td><td>1 个</td><td>8.00</td></tr>");
        sbf.append("<tr><td>红酒杯</td><td>1 个</td><td>30.00</td></tr>");
        sbf.append("<tr><td>*螺片手撕鸡</td><td>1 例</td><td>288.00</td></tr>");
        sbf.append("<tr><td>西芹木耳炒百合</td><td>1 例</td><td>68.00</td></tr>");
        sbf.append("<tr><td>香煎黑豆腐</td><td>1 例</td><td>48.00</td></tr>");
        sbf.append("<tr><td>乡下苦瓜煲</td><td>6 位</td><td>90.00</td></tr>");
        sbf.append("<tr><td>原味西洋菜</td><td>1 例</td><td>48.00</td></tr>");
        sbf.append("<tr><td>*葱油饼（赠）</td><td>1 半打</td><td>0.00</td></tr>");
        sbf.append("<tr><td>柠檬水</td><td>1 扎</td><td>68.00</td></tr>");
        sbf.append("<tr><td>纸巾</td><td>1 盒</td><td>5.00</td></tr>");
        sbf.append("<tr><td>蚝仔烙</td><td>1 例</td><td>108.00</td></tr>");
        sbf.append("</table></FB></FH>");//菜品列表结束

        sbf.append("@@2================================================\n");

        sbf.append("<FH><FB><table>");//金额列表开始
        sbf.append("<tr><td>抹零：</td><td></td><td>-0.40</td></tr>");
        sbf.append("<tr><td>10%服务费：</td><td></td><td>194.00</td></tr>");
        sbf.append("<tr><td>抵预存：</td><td></td><td>2137.00</td></tr>");
        sbf.append("<tr><td>应付金额：</td><td></td><td>2137.00</td></tr>");
        sbf.append("</table></FB></FH>");//金额列表结束

        sbf.append("\n");//换个行控制间隔

        sbf.append("@@22020-12-21 15:56:49\t第2次打印\n");

        sbf.append("\n");//换个行控制间隔

        //下面基本不动
        sbf.append("@@2                   谢谢光临！\n");
        sbf.append("@@2      深圳市福田区侨香路3076号君子广场一楼\n");
        sbf.append("@@2              电话：<FB>0755-8255 3188</FB>\n");
        sbf.append("@@2           如需开发票，请在<FB>30</FB>天之内开出！\n");

        sbf.append("\n");//换个行控制间隔

        //打印二维码
        sbf.append("<QR>测试数据</QR>");

        return sbf.toString();
    }

    /**
     * 模板5---销售总结
     * @param jsonObject
     * @return
     */
    public static String template5(JSONObject jsonObject){

        StringBuffer sbf = new StringBuffer("<MS>0,0</MS>");//设置音量和音效

        sbf.append("<FS2><center>销售总结</center></FS2>\r\n");

        sbf.append("@@22020-12-21 09：00：00---2020-12-22 09：00：00\n");
        //sbf.append("@@2流水号：000016428\n");
        sbf.append("@@2收银点：54654312\t\t\t\t收银员：周文娟\n");//17

        sbf.append("@@2================================================\n");
        //-----------------------------------------------------------------------------------//
        sbf.append("@@2\t<< 整体统计 >>\n");
        sbf.append("<FH><FB><table>");//整体统计列表开始

        sbf.append("<tr><td>菜品销售：</td><td></td><td>43439.40</td></tr>");
        sbf.append("<tr><td>-折扣：</td><td></td><td>-772.40</td></tr>");
        sbf.append("<tr><td>=净销售额：</td><td></td><td>42667.00</td></tr>");
        sbf.append("<tr><td>%2B服务费：</td><td></td><td>3439.00</td></tr>");
        sbf.append("<tr><td>=实收金额：</td><td></td><td>46106.00</td></tr>");
        sbf.append("<tr><td></td><td></td><td></td></tr>");
        sbf.append("<tr><td>单据数目：</td><td></td><td>32</td></tr>");
        sbf.append("<tr><td>顾客人数：</td><td></td><td>129</td></tr>");
        sbf.append("<tr><td>销售/单据：</td><td></td><td>1440.81</td></tr>");
        sbf.append("<tr><td>销售/人数：</td><td></td><td>357.41</td></tr>");

        sbf.append("</table></FB></FH>");//整体统计列表结束
        sbf.append("\n");//换个行控制间隔
        //-----------------------------------------------------------------------------------//
        sbf.append("@@2\t<< 收银总结 >>\n");
        sbf.append("<FH><FB><table>");//收银总结列表开始

        sbf.append("<tr><td>银行卡（农）</td><td>1</td><td>1811.00</td></tr>");
        sbf.append("<tr><td>微信（农）</td><td>8</td><td>14857.00</td></tr>");
        sbf.append("<tr><td>微信（美）</td><td>12</td><td>18878.00</td></tr>");

        sbf.append("<tr><td>美团套餐（68）</td><td>1</td><td>68.00</td></tr>");
        sbf.append("<tr><td>美团套餐（148）</td><td>1</td><td>148.00</td></tr>");
        sbf.append("<tr><td>美团套餐（78）</td><td>2</td><td>156.00</td></tr>");

        sbf.append("<tr><td>vip签单</td><td>1</td><td>1173.00</td></tr>");
        sbf.append("<tr><td>美团（58抵100）</td><td>1</td><td>68.00</td></tr>");
        sbf.append("<tr><td>签单：陈总（公司）</td><td>1</td><td>48.00</td></tr>");
        sbf.append("<tr><td>抵预存</td><td>3</td><td>7963.00</td></tr>");
        sbf.append("<tr><td>美团券（88抵100）</td><td>1</td><td>200.00</td></tr>");
        sbf.append("<tr><td>=合计</td><td>33</td><td>46106.00</td></tr>");

        sbf.append("</table></FB></FH>");//收银总结列表结束
        sbf.append("\n");//换个行控制间隔
        //-----------------------------------------------------------------------------------//
        sbf.append("@@2\t<< 用餐类型 >>\n");
        sbf.append("<FH><FB><table>");//用餐类型列表开始

        sbf.append("<tr><td>堂食</td><td>32</td><td>46106.00</td></tr>");
        sbf.append("<tr><td>=合计</td><td>32</td><td>46106.00</td></tr>");

        sbf.append("</table></FB></FH>");//用餐类型列表结束
        sbf.append("\n");//换个行控制间隔
        //-----------------------------------------------------------------------------------//
        sbf.append("@@2\t<< 营业时间 >>\n");
        sbf.append("<FH><FB><table>");//用餐类型列表开始

        sbf.append("<tr><td>全天</td><td>100.0%</td><td>46106.00</td></tr>");
        sbf.append("<tr><td>=合计</td><td>32</td><td>46106.00</td></tr>");

        sbf.append("</table></FB></FH>");//用餐类型列表结束
        sbf.append("\n");//换个行控制间隔
        //-----------------------------------------------------------------------------------//
        sbf.append("@@2\t<< 大类统计 >>\n");
        sbf.append("<FH><FB><table>");//大类统计列表开始

        sbf.append("<tr><td>未分组</td><td>0.0%</td><td>0.00</td></tr>");
        sbf.append("<tr><td>味部</td><td>5.5%</td><td>2388.00</td></tr>");
        sbf.append("<tr><td>卤水</td><td>9.6%</td><td>4175.00</td></tr>");
        sbf.append("<tr><td>中厨</td><td>48.4%</td><td>21021.00</td></tr>");
        sbf.append("<tr><td>海鲜</td><td>18.4%</td><td>7982.80</td></tr>");
        sbf.append("<tr><td>酒水</td><td>0.3%</td><td>150.00</td></tr>");
        sbf.append("<tr><td>茗茶</td><td>2.1%</td><td>900.00</td></tr>");
        sbf.append("<tr><td>楼面杂项</td><td>1.7%</td><td>739.00</td></tr>");
        sbf.append("<tr><td>烟类</td><td>0.9%</td><td>384.00</td></tr>");
        sbf.append("<tr><td>茶点</td><td>13.1%</td><td>5699.00</td></tr>");
        sbf.append("<tr><td>=合计</td><td></td><td>43439.40</td></tr>");

        sbf.append("</table></FB></FH>");//大类统计列表结束
        sbf.append("\n");//换个行控制间隔
        //-----------------------------------------------------------------------------------//
        sbf.append("@@2\t<< 厨房统计 >>\n");
        sbf.append("<FH><FB><table>");//厨房统计列表开始

        sbf.append("<tr><td>中厨</td><td>59.2%</td><td>25735.00</td></tr>");
        sbf.append("<tr><td>卤水</td><td>9.7%</td><td>4213.00</td></tr>");
        sbf.append("<tr><td>海鲜</td><td>12.9%</td><td>5618.80</td></tr>");
        sbf.append("<tr><td>水吧</td><td>3.3%</td><td>1434.00</td></tr>");
        sbf.append("<tr><td>粤点2</td><td>10.6%</td><td>4597.00</td></tr>");
        sbf.append("<tr><td>粤点1</td><td>2.5%</td><td>1102.60</td></tr>");
        sbf.append("<tr><td>水果</td><td>1.7%</td><td>739.00</td></tr>");
        sbf.append("<tr><td>=合计</td><td></td><td>43439.40</td></tr>");

        sbf.append("</table></FB></FH>");//厨房统计列表结束
        sbf.append("\n");//换个行控制间隔
        //-----------------------------------------------------------------------------------//
        sbf.append("@@2\t<< 钱箱金额 >>\n");
        sbf.append("<FH><FB><table>");//钱箱金额列表开始

        sbf.append("<tr><td>=合计</td><td></td><td>0.00</td></tr>");

        sbf.append("</table></FB></FH>");//钱箱金额列表结束
        sbf.append("\n");//换个行控制间隔
        //-----------------------------------------------------------------------------------//
        sbf.append("@@2\t<< 退菜记录 >>\n");
        sbf.append("<FH><FB><table>");//退菜记录列表开始

        sbf.append("<tr><td>退菜金额</td><td></td><td>1808.00</td></tr>");
        sbf.append("<tr><td>退菜数目</td><td></td><td>37</td></tr>");

        sbf.append("</table></FB></FH>");//退菜记录列表结束
        sbf.append("\n");//换个行控制间隔
        //-----------------------------------------------------------------------------------//
        sbf.append("@@2\t<< 退款记录 >>\n");
        sbf.append("<FH><FB><table>");//退款记录列表开始

        sbf.append("<tr><td>退款金额</td><td></td><td>0.00</td></tr>");
        sbf.append("<tr><td>退款数目</td><td></td><td>0</td></tr>");
        sbf.append("<tr><td></td><td></td><td></td></tr>");
        sbf.append("<tr><td>未结帐单</td><td></td><td>5</td></tr>");
        sbf.append("<tr><td>未结金额</td><td></td><td>21962.00</td></tr>");
        sbf.append("<tr><td></td><td></td><td></td></tr>");
        sbf.append("<tr><td>赠送金额</td><td></td><td>2717.80</td></tr>");
        sbf.append("<tr><td>赠送数量</td><td></td><td>117.00</td></tr>");

        sbf.append("</table></FB></FH>");//退款记录列表结束
        sbf.append("\n");//换个行控制间隔
        //-----------------------------------------------------------------------------------//

        sbf.append("@@2================================================\n");

        sbf.append("\n");//换个行控制间隔

        sbf.append("@@2打印时间：2020-12-21 15:56:49\n");

        sbf.append("\n");//换个行控制间隔
        //打印二维码
        sbf.append("<QR>测试数据</QR>");

        return sbf.toString();
    }

    /**
     * 模板6---划菜单
     * @param jsonObject
     * @return
     */
    public static String template6(JSONObject jsonObject){

        StringBuffer sbf = new StringBuffer("<MS>0,0</MS>");//设置音量和音效

        sbf.append("<FS2><center>【划菜单】</center></FS2>\r\n");
        sbf.append("<FS2><center>E</center></FS2>\r\n");

        sbf.append("<FB>开单时间：2020-12-21 13:10:03</FB>\n");
        //sbf.append("@@2流水号：000016428\n");
        sbf.append("<FB>单号：08073/1</FB>\n");//17
        sbf.append("<FB>桌号：108福捌\t人数：5\t\t服务员：邓丽娟</FB>\n");

        sbf.append("@@2================================================\n");

        sbf.append("<FB><table>");//菜品列表开始
        sbf.append("<tr><td>餐前小食（粤）</td><td>1 份</td><td>38.00</td></tr>");
        sbf.append("</table></FB>");//菜品列表结束

        sbf.append("@@2================================================\n");

        sbf.append("<FB><table>");//金额列表开始
        sbf.append("<tr><td>    总份数：</td><td></td><td>24</td></tr>");
        sbf.append("<tr><td>    小计：</td><td></td><td>3323.40</td></tr>");
        sbf.append("<tr><td>    账单总计：</td><td></td><td>3655.00</td></tr>");
        sbf.append("</table></FB>");//金额列表结束

        sbf.append("<FB>打印时间：\t2020-12-21 15:56:49</FB>\n");

        return sbf.toString();
    }

}
