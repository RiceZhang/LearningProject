package com.zrx.javaAnnotation;

import java.lang.annotation.*;

/**
 * Function:    LearningAnnotation
 * Author:      zhangrixiong
 * DateTime:    2016/8/23 11:44
 *
 * 了解Java Annotation 的机制，java中的注解分为2种，元注解 和 自定义注解
 *       Annotations仅仅是元数据，和业务逻辑无关
 *       @Documented –注解是否将包含在JavaDoc中
 *       @Retention –什么时候使用该注解
 *       @Target? –注解用于什么地方
 *       @Inherited – 是否允许子类继承该注解
 *
 *  那些偷师之地：
 *     [伯乐在线]（http://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651477420&idx=2&sn=1ae3b78f6b07b387d1d64e5198d1f05d&scene=0#rd）
 */



/**
 * 定义作者信息，name和group
 * @author zhangrixiong
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Author {

    String name();
    String group();
}