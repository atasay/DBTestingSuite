package util;

import java.util.Random;

public class StringGenerator {
	public String generateRandomString(int length) {
		char chars[] = new char[length];
		Random rand = new Random();
		for(int i = 0; i < length; i++) {
			chars[i] = (char) (97 + rand.nextInt(26));
		}
		return new String(chars);
	}
}
