package org.zrx.springframework.samples.mvc.data.standard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Locale;

/**
 * Function:    StandardArgumentsController
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:47
 */
public class StandardArgumentsController {

    @RequestMapping(value="/data/standard/request", method= RequestMethod.GET)
    public @ResponseBody String standardRequestArgs(HttpServletRequest request, Principal user, Locale locale) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("request = ").append(request).append(", ");
        buffer.append("userPrincipal = ").append(user).append(", ");
        buffer.append("requestLocale = ").append(locale);
        return buffer.toString();
    }


}
