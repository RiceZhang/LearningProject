package com.zrx.javaAnnotation;

/**
 * Function:    Utility，这是个普通的Java类，运行了@Description和@Author注解。
 * Author:      zhangrixiong
 * DateTime:    2016/8/23 12:46
 */

@Description(value = "这是一个有用的工具类")
public class Utility {

    @Author(name = "haoran_202",group="com.magc")
    public String work()
    {
        //Some business logic is written
        //But it’s not complete yet
        System.out.println("=======================================");
        return "work over!";
    }

}
