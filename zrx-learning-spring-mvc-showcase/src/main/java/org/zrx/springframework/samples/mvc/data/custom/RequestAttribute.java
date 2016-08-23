package org.zrx.springframework.samples.mvc.data.custom;

import java.lang.annotation.*;

/**
 * Created by R on 2016/4/24.
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestAttribute {
    String value();
}
