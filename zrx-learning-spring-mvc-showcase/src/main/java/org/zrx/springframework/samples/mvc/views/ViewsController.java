package org.zrx.springframework.samples.mvc.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Function:    ViewsController
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 18:05
 */
@Controller
@RequestMapping("/views/*")
public class ViewsController {

    @RequestMapping(value="html", method= RequestMethod.GET)
    public String prepare(Model model) {
        model.addAttribute("foo", "bar");
        model.addAttribute("fruit", "apple");
        return "views/html";
    }

}
