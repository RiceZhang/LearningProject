package org.zrx.springframework.mvc.extensions.ajax;

import org.springframework.web.context.request.WebRequest;

/**
 * Function:    AjaxUtils
 * Author:      Apple
 * DateTime:    2016/8/22 17:14
 */
public class AjaxUtils {
    /**
     * 通过 获取请求头属性： X-Requested-Width 判断是否 Ajax 请求
     * @param webRequest
     * @return
     */
    public static boolean isAjaxRequest(WebRequest webRequest) {
            String requestedWith = webRequest.getHeader("X-Requested-Width");
            return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
        }

        public static boolean isAjaxUploadRequest(WebRequest webRequest) {
            return webRequest.getParameter("ajaxUpload") != null;
        }

        private AjaxUtils() {}
}
