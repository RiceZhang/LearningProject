package org.zrx.springframework.samples.mvc.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Function:    ExceptionController
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:52
 */

@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    public @ResponseBody
    String exception() {
        throw new IllegalStateException("Sorry!");
    }

    @RequestMapping("/global-exception")
    public @ResponseBody String businessException() throws BusinessException {
        throw new BusinessException();
    }

    @ExceptionHandler
    public @ResponseBody String handle(IllegalStateException e) {
        return "IllegalStateException handled!";
    }

}
