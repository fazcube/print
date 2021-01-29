package com.yilianyun.print.common.print;

import com.alibaba.fastjson.JSONObject;
import com.yly.java.yly_sdk.RequestMethod;

import static com.yilianyun.print.common.print.PrintData.*;
import static com.yilianyun.print.common.print.PrintData.ORIGIN_ID;

/** 
 * @Description: 打印工具类 
 * @Author: By fazcube
 * @email 1473074805@qq.com
 * @Date: 2021/1/29
 */
public class PrintUtil {

    /**
     * 得到token
     * @return 返回获取到的token
     * @throws Exception 异常捕获
     */
    public static String getToken() throws Exception {
        //初始化
        RequestMethod.getInstance().init(CLIENT_ID,CLIENT_SECRET);
        //获取json数据得到token
        JSONObject token = JSONObject.parseObject(RequestMethod.getInstance().getAccessToken());
        String access_token = token.getJSONObject("body").getString("access_token");
        return access_token;
    }

    /**
     * 最基本的打印方法
     * @param str 要打印的字符串
     * @param machineCode 打印机的终端号
     * @param machineSign 打印机的密钥
     * @return 返回打印数据
     * @throws Exception 涉及到json
     */
    public static JSONObject print(String str,String machineCode,String machineSign) throws Exception {
        //初始化
        RequestMethod.getInstance().init(CLIENT_ID,CLIENT_SECRET);
        //添加打印机
        RequestMethod.getInstance().addPrinter(machineCode, machineSign, ACCESS_TOKEN);
        //接收数据输出查看
        String result = RequestMethod.getInstance().printIndex(ACCESS_TOKEN,machineCode,str,ORIGIN_ID);
        //把result转换为json数据，便于传输
        return JSONObject.parseObject(result);
    }


    /**
     * 最基本的打印方法,测试用
     * @param str
     * @return
     * @throws Exception
     */
    public static JSONObject print_1(String str) throws Exception {
        //初始化
        RequestMethod.getInstance().init(CLIENT_ID,CLIENT_SECRET);
        //添加打印机
        RequestMethod.getInstance().addPrinter("MACHINE_CODE_1", "MACHINE_SIGN_1", ACCESS_TOKEN);
        //接收数据输出查看
        String result = RequestMethod.getInstance().printIndex(ACCESS_TOKEN,"MACHINE_CODE_1",str,ORIGIN_ID);
        //把result转换为json数据，便于传输
        return JSONObject.parseObject(result);
    }
}
