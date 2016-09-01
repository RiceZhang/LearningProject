package org.zrx.springframework.samples.mvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Function:    MappingController
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:55
 */
@Controller
public class MappingController {

    @RequestMapping("/mapping/path")
    public @ResponseBody String byPath() {
        return "Mapped by path!";
    }

    @RequestMapping(value="/mapping/path/*", method = RequestMethod.GET)
    public @ResponseBody String byPathPattern(HttpServletRequest request) {
        return "Mappped by path pattern( " + request.getRequestURI() + ")";
    }

    @RequestMapping(value = "/mapping/method", method=RequestMethod.GET)
    public @ResponseBody String byMethod() {
        return "Mapped by path + method";
    }

    @RequestMapping(value = "/mapping/parameter", method = RequestMethod.GET, params = "foo" )
    public @ResponseBody String  byParameter() {
        return "Mapped by path + method + presence of query parameter! ";
    }

    public  @ResponseBody String byParameterNegation() {
        return "Mapped by path ";
    }
}
