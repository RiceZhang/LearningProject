package org.zrx.springframework.samples.mvc.async;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * @api {get} /user/:id Request User information
 * @apiName GetUser
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

@Controller
@RequestMapping("/async/callable")
public class CallableController {

    @RequestMapping("/response-body")
    public @ResponseBody   Callable<String> callable() {
          return new Callable<String>() {  // J.U.C
              @Override
              public String call() throws Exception {
                  Thread.sleep(2000);
                  return "Callable result";
              }
          };
    }

    @RequestMapping("/view")
    public Callable<String> callablewithView(final Model model){
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                model.addAttribute("foo","bar");
                model.addAttribute("fruit","apple");
                return "view/html";
            }
        };
    }


    @RequestMapping("/exception")
    public @ResponseBody Callable<String> callableWithException(
            final @RequestParam(required=false, defaultValue="true") boolean handled) {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                if (handled) {
                    throw new IllegalStateException("Callable error");
                }
                else {
                    throw new IllegalArgumentException("Callable error");
                }
            }
        };
    }


    @RequestMapping("/custom-timeout-handling")
    public @ResponseBody WebAsyncTask<String> callableWithCustomTimeoutHandling() {
           Callable<String> callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(2000);
                    return "Callable result";
                }
        };
        return new WebAsyncTask<String>(1000, callable);
    }


    @ExceptionHandler
    @ResponseBody
    public String handleException(IllegalStateException ex) {
        return "Handled exception: " + ex.getMessage();
    }

}
