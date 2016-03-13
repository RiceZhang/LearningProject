package design_pattern.creational.factoryMethod.case01.impl;

import design_pattern.creational.factoryMethod.case01.Sender;

public class SmsSender implements Sender {

	@Override
	public void Send() {
		System.out.println("发送短信");		
	}

}
