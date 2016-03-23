package com.github.learning.desigerPattern.factoryMethod.classFactory.factory;

import com.github.learning.desigerPattern.factoryMethod.classFactory.Sender;
import com.github.learning.desigerPattern.factoryMethod.classFactory.impl.MailSender;
import com.github.learning.desigerPattern.factoryMethod.classFactory.impl.SmsSender;

/** Class Case : FactoryMethod
 * 实例工厂
 * @author: zhangrx
 * @date: 2016/3/22 21:27
 */
public class SendFactory {

    /**
     * 实例工厂：生产者
     * @param type
     * @return
     */
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        }else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

}
