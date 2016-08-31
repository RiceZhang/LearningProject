package org.zrx.springframework.samples.mvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Function:    ClasslevelMappingController
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:55
 */
@Controller
@RequestMapping("/class-mapping/*")
public class ClasslevelMappingController {

    @RequestMapping("/path")
    public @ResponseBody String byPath() {
        return "Mapped by path!";
    }

    @RequestMapping(value="/mapping/path/*", method= RequestMethod.GET)
    public @ResponseBody String byPathPattern(HttpServletRequest request) {
        return "Mapped by path pattern ('" + request.getRequestURI() + "')";
    }

}
