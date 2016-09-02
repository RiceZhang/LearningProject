package org.zrx.springframework.samples.mvc.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zrx.springframework.mvc.extensions.ajax.AjaxUtils;

import javax.validation.Valid;

/**
 * Function:    FormController
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:54
 */
@Controller
@RequestMapping("/form")
@SessionAttributes("formBean")  // 从 session 中获取回话信息 formBean (反射获取)
public class FormController {

    // 没一个请求 都调用该方法
    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
        model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }

    // 初始化时，被调用 创建 "form" 属性
    // 创建表单信息 "form" 放到 http session 中
    @ModelAttribute("formBean")
    public FormBean createFormBean() {
        return new FormBean();
    }

    @RequestMapping(method= RequestMethod.GET)
    public void form() {
    }

    @RequestMapping(method=RequestMethod.POST)
    public String processSubmit(@Valid FormBean formBean, BindingResult result,
                                @ModelAttribute("ajaxRequest") boolean ajaxRequest,
                                Model model, RedirectAttributes redirectAttrs) {

        if(result.hasErrors()) {
             return null;
        }
        // 经典的例子： 这里会做一些保存表单数据到 db 的操作 以及从session清除 "form" 中的数据属性
        // 例如：SessionStatus.setCompleted() . 在这个例子中，我们还会保存 "form"信息到session中
        String message = "表单提交成功. ";
        // 成功请求
        if (ajaxRequest) {
            // 把本次请求的数据呈现 到 客户端
            model.addAttribute("message", message);
            return null;
        } else {
            // 保存成功的信息 通过重定向把数据带到下一个请求中
            redirectAttrs.addFlashAttribute("message",message);
            return  "redirect:/form";
        }
    }
}
