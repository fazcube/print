package com.yilianyun.print.controller;

import com.alibaba.fastjson.JSONObject;

import com.yilianyun.print.common.PrintTemplate;
import com.yilianyun.print.common.PrintUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class Hello {

    PrintTemplate printTemplate;
    PrintUtil printUtil;

    /**
     * 测试api用
     * @return
     */
    @RequestMapping("/spring")
    public String helloSpring(){
        return "Hello World!";
    }

    /**
     * 测试打印用
     * @param jsonObject
     * @return
     * @throws Exception
     */
    @RequestMapping("/printTest")
    public JSONObject printTest(@RequestBody JSONObject jsonObject) throws Exception {
        //json转换字符串模板
        String str = "打印出 %2B 号";
        //调用打印方法
        JSONObject json = printUtil.print(str);
        //返回打印结果
        return json;
    }

    /**
     * 模板1---预结单
     * @param jsonObject
     * @return
     * @throws Exception
     */
    @RequestMapping("/print1")
    public JSONObject Print1(@RequestBody JSONObject jsonObject) throws Exception {
        //json转换字符串模板
        String str = printTemplate.template1(jsonObject);
        //调用打印方法
        JSONObject json = printUtil.print(str);
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
    public JSONObject Print2(@RequestBody JSONObject jsonObject) throws Exception {
        //json转换字符串模板
        String str = printTemplate.template2(jsonObject);
        //调用打印方法
        JSONObject json = printUtil.print(str);
        //返回打印结果
        return json;
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
        String str = printTemplate.template3(jsonObject);
        //调用打印方法
        JSONObject json = printUtil.print(str);
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
        String str = printTemplate.template4(jsonObject);
        //调用打印方法
        JSONObject json = printUtil.print(str);
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
        String str = printTemplate.template5(jsonObject);
        //调用打印方法
        JSONObject json = printUtil.print(str);
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
        String str = printTemplate.template6(jsonObject);
        //调用打印方法
        JSONObject json = printUtil.print(str);
        //返回打印结果
        return json;
    }
}
