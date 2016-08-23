package org.zrx.springframework.samples.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Function:    GlobalExceptionHandler
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:52
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public @ResponseBody
    String handleBusinessException(BusinessException ex) {
        return "Handled BusinessException";
    }

}
