package com.github.learning.desigerPattern.factoryMethod.classFactory.impl;

import com.github.learning.desigerPattern.factoryMethod.classFactory.Sender;

/**
 * Class Case : FactoryMethod
 * 发送邮件实例
 * @author: zhangrx
 * @date: 2016/3/22 21:29
 */
public class MailSender implements Sender {

    /**
     * 发送信息 ，不管你施法短信还是发邮件、还是发微信，发qq信息
     */
    @Override
    public void Send() {
            // 实现发送邮件业务

    }


}
