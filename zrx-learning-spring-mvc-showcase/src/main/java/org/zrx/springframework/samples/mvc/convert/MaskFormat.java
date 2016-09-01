package org.zrx.springframework.samples.mvc.convert;

import java.lang.annotation.*;

/**
 * 自定义注解
 * Function:    MaskFormat
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:43
 */
@Target(value={ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)   // 运行阶段，以为着可以采用反射
@Documented
public @interface MaskFormat {
    String value();
}
