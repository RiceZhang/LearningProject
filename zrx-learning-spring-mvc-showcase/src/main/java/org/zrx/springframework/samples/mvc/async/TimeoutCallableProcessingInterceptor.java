package org.zrx.springframework.samples.mvc.async;


import java.util.concurrent.Callable;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;

/**
 * Function:    TimeoutCallableProcessingInterceptor 时间超市
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:19
 */
public class TimeoutCallableProcessingInterceptor extends CallableProcessingInterceptorAdapter {

    @Override
    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
        throw new IllegalStateException("[" + task.getClass().getName() + "] timed out");
    }

}

