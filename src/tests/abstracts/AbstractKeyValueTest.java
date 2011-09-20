package tests.abstracts;

import db.interfaces.KeyValueConnection;

public abstract class AbstractKeyValueTest {
	
	protected KeyValueConnection connection;
	
	public AbstractKeyValueTest(KeyValueConnection connection) {
		this.connection = connection;
	}
	
	public void initialize() {
		connection.initialize();
	}
	
	public void shutDown() {
		connection.shutDown();
	}
}
