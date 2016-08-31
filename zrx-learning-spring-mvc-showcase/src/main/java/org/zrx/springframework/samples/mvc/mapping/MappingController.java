package org.zrx.springframework.samples.mvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
