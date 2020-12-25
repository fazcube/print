package com.yilianyun.print.common;

import com.alibaba.fastjson.JSONObject;
import com.yly.java.yly_sdk.RequestMethod;

import static com.yilianyun.print.common.PrintData.*;
import static com.yilianyun.print.common.PrintData.ORIGIN_ID;

/**
 * 打印工具类
 */
public class PrintUtil {

    /**
     * 得到token
     * @return
     * @throws Exception
     */
    public static String getToken() throws Exception {
        //获取json数据得到token
        JSONObject token = JSONObject.parseObject(RequestMethod.getInstance().getAccessToken());
        String access_token = token.getJSONObject("body").getString("access_token");
        return access_token;
    }

    /**
     * 最基本的打印方法
     * @param str
     * @return
     * @throws Exception
     */
    public static JSONObject print(String str) throws Exception {
        //初始化
        RequestMethod.getInstance().init(CLIENT_ID,CLIENT_SECRET);
        //添加打印机
        RequestMethod.getInstance().addPrinter(MACHINE_CODE, MSIGN, ACCESS_TOKEN);
        //接收数据输出查看
        String result = RequestMethod.getInstance().printIndex(ACCESS_TOKEN,MACHINE_CODE,str,ORIGIN_ID);
        //把result转换为json数据，便于传输
        return JSONObject.parseObject(result);
    }
}
