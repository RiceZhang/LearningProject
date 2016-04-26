package org.springframework.samples.mvc.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by R on 2016/4/23.
 * 解析：springMVC的简单使用
 */
@Controller
public class SimpleController {
    /**
     * @RequestMapping("/simple") 代表访问路径
     * @ResponseBody 用于返回json
     * <pre/>
     *
     * @return
     */
    @RequestMapping("/simple")
    public @ResponseBody String simple() {
        return "Hello world!";
    }


}
