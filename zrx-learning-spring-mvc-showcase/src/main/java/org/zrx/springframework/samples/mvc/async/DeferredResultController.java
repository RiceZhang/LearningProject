package org.zrx.springframework.samples.mvc.async;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Function:    DeferredResultController
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:19
 *
 * Rest JSON API 区别于 RPC JSON API ,REST 更多的是名词+pull、delete、put...etc
 */

@Controller
@RequestMapping("/async")
public class DeferredResultController {

    // J.U.C
    private final Queue<DeferredResult<String>> responseBodyQueue = new ConcurrentLinkedQueue<DeferredResult<String>>();
    private final Queue<DeferredResult<ModelAndView>> mavQueue = new ConcurrentLinkedQueue<DeferredResult<ModelAndView>>();
    private final Queue<DeferredResult<String>> exceptionQueue = new ConcurrentLinkedQueue<DeferredResult<String>>();

    /**
     * 延迟结果
     * @return
     */
    @RequestMapping("/deferred-result/response-body")
    public @ResponseBody DeferredResult<String> deferredResult() {
        DeferredResult<String> result = new DeferredResult<String>();
        this.responseBodyQueue.add(result);
        return null;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/deferred-result/model-and-view")
    public DeferredResult<ModelAndView> deferredResultWithView() {
        DeferredResult<ModelAndView> result = new DeferredResult<ModelAndView>();
        this.mavQueue.add(result);
        return result;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/deferred-result/exception")
    public @ResponseBody DeferredResult<String> deferredResultWithException() {
        DeferredResult<String> result = new DeferredResult<String>();
        this.exceptionQueue.add(result);
        return result;
    }

    @RequestMapping("/deferred-result/timeout-value")
    public @ResponseBody DeferredResult<String> deferredResultWithTimeoutValue() {
        // 提供一个默认值，防止时间超时，以及覆盖时间值
        // 可以在Spring 的上下文配置中设置，本例子是在：set in src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml，但更多人喜欢放在resource 目录下
        return new DeferredResult<String>(1000L, "Deferred result after timeout");
    }

    @Scheduled(fixedRate = 2000)
    public void processQueues() {
        for (DeferredResult<String> result : this.responseBodyQueue) {

        }
        for (DeferredResult<String> result : this.exceptionQueue) {
            result.setErrorResult(new IllegalStateException("DeferredResult error"));
            this.exceptionQueue.remove(result);
        }
        for (DeferredResult<ModelAndView> result : this.mavQueue) {
            result.setResult(new ModelAndView("views/html", "javaBean", new JavaBean("bar", "apple")));
            this.mavQueue.remove(result);
        }

    }
}
