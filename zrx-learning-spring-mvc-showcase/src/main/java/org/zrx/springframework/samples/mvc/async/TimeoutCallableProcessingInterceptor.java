package org.zrx.springframework.samples.mvc.async;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.concurrent.Callable;

/**
 * Function:    TimeoutCallableProcessingInterceptor
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:19
 */
public class TimeoutCallableProcessingInterceptor extends CallableProcessingInterceptorAdapter {

    @Override
    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
        throw new IllegalStateException("[" + task.getClass().getName() + "] timed out");
    }

}
