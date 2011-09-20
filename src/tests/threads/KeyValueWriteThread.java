package tests.threads;

import util.StringGenerator;
import db.interfaces.KeyValueConnection;

public class KeyValueWriteThread extends Thread {
	
	private int id, n, dataLength;
	private KeyValueConnection connection;
	
	public KeyValueWriteThread(int id, KeyValueConnection connection, int n, int dataLength) {
		this.id = id;
		this.connection = connection;
		this.n = n;
		this.dataLength = dataLength;
	}
	
	@Override
	public void run() {
		StringGenerator gen = new StringGenerator();
		for(int i = 0; i < n; i++) {
			String value = gen.generateRandomString(dataLength);
			connection.write("t" + id + "k" + i, value);
		}
	}
}
