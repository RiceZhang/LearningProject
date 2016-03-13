package design_pattern.creational.factoryMethod.case02.factory;

import design_pattern.creational.factoryMethod.case01.Sender;
import design_pattern.creational.factoryMethod.case01.impl.MailSender;
import design_pattern.creational.factoryMethod.case01.impl.SmsSender;

public class SendFactory {
	
	/* 生产方法1  */
	public static MailSender produceMail(){
		return new MailSender();
	}
	
	/* 生产方法2 */
	public static Sender produceSms() {
		return new SmsSender();
	}
	
	
}
