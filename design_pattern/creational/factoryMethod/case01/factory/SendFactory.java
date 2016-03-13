package design_pattern.creational.factoryMethod.case01.factory;

import design_pattern.creational.factoryMethod.case01.Sender;
import design_pattern.creational.factoryMethod.case01.impl.MailSender;
import design_pattern.creational.factoryMethod.case01.impl.SmsSender;

public class SendFactory {
	
	/**
	 * 工厂方法
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
