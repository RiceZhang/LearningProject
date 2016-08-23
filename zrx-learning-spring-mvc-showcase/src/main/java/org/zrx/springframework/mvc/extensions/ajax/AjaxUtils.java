package org.zrx.springframework.mvc.extensions.ajax;

import org.springframework.web.context.request.WebRequest;

/**
 * Function:    AjaxUtils
 * Author:      Apple
 * DateTime:    2016/8/22 17:14
 *
 * AjaxUtils 工具类主要是功能
 * 1） 判断是否AjaxRequest
 * 2)  判断是否AjaxUpload
 */
public class AjaxUtils {

    public static boolean isAjaxRequest(WebRequest webRequest) {
        String requestedWith = webRequest.getHeader("X-Requested-With");
        return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
    }

    public static boolean iaAjaxUploadRequest(WebRequest webRequest) {
        return webRequest.getParameter("ajaxUpload") != null;
    }

    private AjaxUtils() {}

}
