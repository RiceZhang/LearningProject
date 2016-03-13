package design_pattern.creational.factoryMethod.case01;

import design_pattern.creational.factoryMethod.case01.factory.SendFactory;

public class Test {
	
	public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("sms");  
        sender.Send();  
    }
	
	
}
