package org.zrx.springframework.mvc.extensions.ajax;

import org.springframework.web.context.request.WebRequest;

public class AjaxUtils {
	
    /**
	 * @api {get} /user/:id XX
	 * @apiName GetUserXXX
	 * @apiGroup User
	 *
	 * @apiParam {Number} id Users unique ID.
	 *
	 * @apiSuccess {String} firstname Firstname of the User.
	 * @apiSuccess {String} lastname  Lastname of the User.
	 *
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 200 OK
	 *     {
	 *       "firstname": "John",
	 *       "lastname": "Doe"
	 *     }
	 *
	 * @apiError UserNotFound The id of the User was not found.
	 *
	 * @apiErrorExample Error-Response:
	 *     HTTP/1.1 404 Not Found
	 *     {
	 *       "error": "UserNotFound"
	 *     }
	 */
    public static boolean isAjaxRequest(WebRequest webRequest) {
            String requestedWith = webRequest.getHeader("X-Requested-Width");
            return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
    }

    /**
	 * @api {POST} /user/:id Request User inXXX
	 * @apiName GetUserxxx
	 * @apiGroup User
	 *
	 * @apiParam {String} id Users unique ID.
	 *
	 * @apiSuccess {String} firstname Firstname of the User.
	 * @apiSuccess {String} lastname  Lastname of the User.
	 *
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 200 OK
	 *     {
	 *       "firstname": "John",
	 *       "lastname": "Doe"
	 *     }
	 *
	 * @apiError UserNotFound The id of the User was not found.
	 *
	 * @apiErrorExample Error-Response:
	 *     HTTP/1.1 404 Not Found
	 *     {
	 *       "error": "UserNotFound"
	 *     }
	 */
	public static boolean isAjaxUploadRequest(WebRequest webRequest) {
		return webRequest.getParameter("ajaxUpload") != null;
	}

    private AjaxUtils() {}
}
