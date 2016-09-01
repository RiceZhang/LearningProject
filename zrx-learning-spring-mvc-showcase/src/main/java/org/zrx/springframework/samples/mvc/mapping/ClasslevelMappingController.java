package org.zrx.springframework.samples.mvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
         return "路径匹配";
    }

    @RequestMapping(value = "/path/*", method = RequestMethod.GET)
    public @ResponseBody String byPathPattern(HttpServletRequest request){
        return "路径 样式 进行匹配：访问路径URI(" + request.getRequestURI() +")";
    }

    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public @ResponseBody String byMethod() {
        return " 路径 + 方法进行 匹配:";
    }

    @RequestMapping(value = "/parameter", method = RequestMethod.GET,params = "foo")
    public @ResponseBody String byParameter() {
        return "映射路径+方法+查询参数!";
    }

    @RequestMapping(value = "/parameter", method = RequestMethod.GET,params = "!foo")
    public @ResponseBody String  byParameterNegation() {
        return "映射路径+方法+查询 否定参数!";
    }

    @RequestMapping(value="/header",method = RequestMethod.GET, headers = "foo")
    public @ResponseBody String byHeader() {
        return "映射路径 + 方法 + Http头Header参数!";
    }

    @RequestMapping(value = "/notheader", method = RequestMethod.GET, headers = "!foo")
    public @ResponseBody String byHeaderNegation() {
        return "映射路径 + 方法 + Http头  缺失Header参数!";
    }

    @RequestMapping(value = "/consumes", method = RequestMethod.POST, consumes = "application/json" )
    public @ResponseBody String byConsumes(@RequestBody JavaBean javaBean) {
        return "映射路径  +  方法  +  可消费  媒体类型";
    }

    @RequestMapping(value = "/produces", method = RequestMethod.GET, produces="application/json")
    public JavaBean byProduces() {
        return new JavaBean(); // 生产者类型
    }

}
