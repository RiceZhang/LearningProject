package design_pattern.creational.factoryMethod.case02.impl;

import design_pattern.creational.factoryMethod.case01.Sender;

public class MailSender implements Sender {

	@Override
	public void Send() {
		System.out.println("发送邮件");		
	}

}
