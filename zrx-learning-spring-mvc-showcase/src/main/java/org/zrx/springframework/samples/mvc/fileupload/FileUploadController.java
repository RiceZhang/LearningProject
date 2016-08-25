package org.zrx.springframework.samples.mvc.fileupload;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.context.request.WebRequest;
        import org.zrx.springframework.mvc.extensions.ajax.AjaxUtils;

/**
 * Function:    FileUploadController
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:53
 */

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
        model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }


}
