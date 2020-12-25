package com.yilianyun.print.entity;

import lombok.Data;

/**
 * 菜品对象
 * @author admin
 *
 */
@Data
public class Test {
    // 菜品名称
    private String name;
    // 价格
    private double money;
    // 数量
    private Integer num;
    //菜品分类
    private String type;
    public Test() {
        super();
    }
    public Test(String name, double money, Integer num,String type) {
        super();
        this.name = name;
        this.money = money;
        this.num = num;
        this.type=type;
    }
}
