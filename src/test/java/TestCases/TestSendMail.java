package TestCases;

import Utilities.Constant;
import Utilities.Mailer;

public class TestSendMail {

	public static void main(String[] args) {
	
		Mailer.send(Constant.from,Constant.Password,Constant.to,"hello Rajat","How r u?");  

	}

}
