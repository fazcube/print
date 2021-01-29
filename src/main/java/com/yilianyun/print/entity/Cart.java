package com.yilianyun.print.entity;

import lombok.Data;

/**
 * 菜品对象
 * @author admin
 *
 */
@Data
public class Cart {
    // 菜品名称
    private String name;
    // 价格
    private String money;
    // 数量
    private String num;
    //单位
    private String unit;

    public Cart() {
        super();
    }
    public Cart(String name, String money, String num, String unit) {
        super();
        this.name = name;
        this.money = money;
        this.num = num;
        this.unit = unit;
    }
}
