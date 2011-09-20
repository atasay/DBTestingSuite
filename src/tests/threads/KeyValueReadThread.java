package tests.threads;

import db.interfaces.KeyValueConnection;

public class KeyValueReadThread extends Thread {
	
	private int id, n;
	private KeyValueConnection connection;
	
	public KeyValueReadThread(int id, KeyValueConnection connection, int n) {
		this.id = id;
		this.connection = connection;
		this.n = n;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < n; i++) {
			connection.read("t" + id + "k" + i);
		}
	}
}
