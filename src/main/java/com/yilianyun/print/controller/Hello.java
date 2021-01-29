package com.yilianyun.print.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.yilianyun.print.common.client.ClientUtil;
import com.yilianyun.print.common.print.PrintTemplate;
import com.yilianyun.print.common.print.PrintUtil;
import com.yilianyun.print.common.redis.RedisUtil;
import com.yilianyun.print.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jy")
public class Hello {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * getToken
     * @return token
     */
    @RequestMapping("/getToken")
    public String getToken() throws Exception {
        return PrintUtil.getToken();
    }

    @RequestMapping("/getRedis")
    public String getRedis(){
        boolean has = setRedis();
        if(!has){
            return "获取打印机数据失败！";
        }
        return "获取打印机数据成功!";
    }

    /**
     * 测试打印用
     * @return Hello World!
     * @throws Exception 转换json数据时可能会抛出异常
     */
    @RequestMapping("/printTest")
    public Result<?> printTest(@RequestBody JSONObject jsonObject) {
        try{
            String machine_code = jsonObject.getString("machineCode");
            String machine_sign = jsonObject.getString("machineSign");
            PrintUtil.print("测试打印输出\n测试打印输出\n测试打印输出",machine_code,machine_sign);
        }catch (Exception e){
            return Result.error("打印失败！");
        }
        return Result.OK("打印成功！");
    }

    /**
     * 模板1---预结单
     * @param jsonObject 前端传来的需要打印的json数据
     * @return 返回打印结果
     * @throws Exception 转换json数据时可能会抛出异常
     */
    @RequestMapping("/print1")
    public JSONObject Print1(@RequestBody JSONObject jsonObject) throws Exception {
        //json转换字符串模板
        String str = PrintTemplate.template1(jsonObject);
        //调用打印方法
        JSONObject json = PrintUtil.print_1(str);
        //返回打印结果
        return json;
    }

    /**
     * 模板2---买单
     * @param jsonObject
     * @return
     * @throws Exception
     */
    @RequestMapping("/print2")
    public Result<?> Print2(@RequestBody JSONObject jsonObject) throws Exception {
        boolean has = setRedis();
        if(!has){
            return Result.error("获取打印机数据失败！");
        }
        JSONObject json = new JSONObject();
        //返回打印结果
        try{
            String machine_code = jsonObject.getString("machineCode");
            String machine_sign = String.valueOf(redisUtil.get("machineCode"));
            //json转换字符串模板
            String str = PrintTemplate.template2(jsonObject);
            //调用打印方法
            json = PrintUtil.print(str,machine_code,machine_sign);
        }catch (Exception e){
            return Result.error("打印失败！");
        }
        return Result.OK("打印成功！",json);
    }

    /**
     * 模板3---vip签单
     * @param jsonObject
     * @return
     * @throws Exception
     */
    @RequestMapping("/print3")
    public JSONObject Print3(@RequestBody JSONObject jsonObject) throws Exception {
        //json转换字符串模板
        String str = PrintTemplate.template3(jsonObject);
        //调用打印方法
        JSONObject json = PrintUtil.print_1(str);
        //返回打印结果
        return json;
    }

    /**
     * 模板4---预存单
     * @param jsonObject
     * @return
     * @throws Exception
     */
    @RequestMapping("/print4")
    public JSONObject Print4(@RequestBody JSONObject jsonObject) throws Exception {
        //json转换字符串模板
        String str = PrintTemplate.template4(jsonObject);
        //调用打印方法
        JSONObject json = PrintUtil.print_1(str);
        //返回打印结果
        return json;
    }

    /**
     * 模板5---销售总结
     * @param jsonObject
     * @return
     * @throws Exception
     */
    @RequestMapping("/print5")
    public JSONObject Print5(@RequestBody JSONObject jsonObject) throws Exception {
        //json转换字符串模板
        String str = PrintTemplate.template5(jsonObject);
        //调用打印方法
        JSONObject json = PrintUtil.print_1(str);
        //返回打印结果
        return json;
    }

    /**
     * 模板6---划菜单
     * @param jsonObject
     * @return
     * @throws Exception
     */
    @RequestMapping("/print6")
    public JSONObject Print6(@RequestBody JSONObject jsonObject) throws Exception {
        //json转换字符串模板
        String str = PrintTemplate.template6(jsonObject);
        //调用打印方法
        JSONObject json = PrintUtil.print_1(str);
        //返回打印结果
        return json;
    }

    @RequestMapping("/printSplit")
    public Result<?> printSplit(@RequestBody JSONObject jsonObject) throws Exception {

        boolean has = setRedis();
        if(!has){
            return Result.error("获取打印机数据失败！");
        }
        boolean flag = false;
        //json转换字符串模板
        JSONArray array = jsonObject.getJSONArray("cart");
        String createTime = jsonObject.getString("createtime");
        String orderId = jsonObject.getString("orderid");
        String serviceName = jsonObject.getString("service_name");

        String bindName2 = jsonObject.getString("bind_name_2");
        String peopleNum = jsonObject.getString("people_num");

        String wait = jsonObject.getString("wait");

        for(int i = 0;i<array.size();i++){
            Map<String,String> printData = new HashMap<>();
            StringBuffer sbf = new StringBuffer("<MS>0,0</MS>");//设置音量和音效

            sbf.append("<FS2><center>【厨房/分单】</center></FS2>\r\n");
            sbf.append("<FS2><center>E</center></FS2>\r\n");

            sbf.append("@@2桌号："+bindName2+"\t\t单号："+orderId+"\n");
            sbf.append("@@2人数："+peopleNum+"\t\t\t\t\t服务员："+serviceName+"\n");

            sbf.append("@@2================================================\n");
            sbf.append("<FH><FB><table>");//菜品列表开始
            //循环取到
            JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(array.get(i)));
            String num = json.getString("num");
            String sp = json.getJSONObject("sp").getString("name");
            String name = json.getJSONObject("prod").getString("name");

            sbf.append("<tr><td>"+name+"</td><td>"+num+" "+sp+"</td></tr>");
            if(wait.equals("true")){
                sbf.append("<tr><td>*（等叫）</td></tr>");
            }

            sbf.append("</table></FB></FH>");//菜品列表结束
            sbf.append("@@2================================================\n");

            sbf.append("@@2【未付款】\n");
            sbf.append("@@2****下单时间:"+createTime+"****\n");

            printData.put("printCode","4004721370");
            printData.put("printString",sbf.toString());

            String deptName = json.getJSONObject("prod").getString("deptname");
            String str = String.valueOf(redisUtil.get(deptName));
            String[] strArray = str.split(",");
            try {
                PrintUtil.print(sbf.toString(),strArray[0],strArray[1]);
                flag = true;
            }catch (Exception e){
                flag = false;
            }
        }
        if(flag){
            return Result.OK("打印成功！");
        }
        return Result.error("打印失败！");
    }

    /**
     * 获取服务器后台的打印机数据并存在redis中
     * @return 返回结果
     */
    public boolean setRedis(){
        boolean has = redisUtil.hasKey("printData");
        if(has){
            return true;
        }
        try{
            String json = ClientUtil.sendPost(
                    "http://smj2.51js.net.cn/api/printer.php",
                    "fun=getPrinters&appid=wx144bef52dd2a5475");
            JSONObject newJson = JSONObject.parseObject(json.substring(136,json.length()));
            System.out.println(newJson);
            JSONArray array = newJson.getJSONArray("data");

            for(int i=0;i<array.size();i++){
                JSONObject json1 = JSONObject.parseObject(JSONObject.toJSONString(array.get(i)));
                redisUtil.set("printData","initPrintData",8*60*60);
                redisUtil.set(json1.getString("deptname"),json1.getString("id")+","+json1.getString("secret"),8*60*60);
                redisUtil.set(json1.getString("id"),json1.getString("secret"),8*60*60);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
