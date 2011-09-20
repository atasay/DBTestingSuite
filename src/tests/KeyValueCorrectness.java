package tests;

import db.interfaces.KeyValueConnection;
import tests.abstracts.AbstractKeyValueTest;
import util.StringGenerator;
import util.TestLog;

public class KeyValueCorrectness extends AbstractKeyValueTest {

	public KeyValueCorrectness(KeyValueConnection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public boolean test() {
		TestLog.log("KEY-VALUE CORRECTNESS TEST");
		
		try {
			StringGenerator gen = new StringGenerator();
			
			String value = gen.generateRandomString(32);
			connection.write("testkey", value);
			String readValue = connection.read("testkey");
			
			if(readValue.equals(value)) {
				TestLog.log("Correctness OK!");
				return true;
			} else {
				TestLog.log("Correctness FAILED!");
				return false;
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
