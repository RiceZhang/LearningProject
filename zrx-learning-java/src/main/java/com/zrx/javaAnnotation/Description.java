package com.zrx.javaAnnotation;

import java.lang.annotation.*;

/**
 * Function:    Description
 * Author:      zhangrixiong
 * DateTime:    2016/8/23 12:45
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Description {
     String value();
}

