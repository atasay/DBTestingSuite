package tests.abstracts;

import db.interfaces.KeyValueConnection;

public abstract class AbstractKeyValueThreadedTest {
	
	protected KeyValueConnection[] connections;
	protected int threadCount;
	
	public AbstractKeyValueThreadedTest(KeyValueConnection[] connections) {
		this.connections = connections;
		this.threadCount = connections.length;
	}
	
	public void initialize() {
		for(KeyValueConnection connection : this.connections) {
			connection.initialize();
		}
	}
	
	public void shutDown() {
		for(KeyValueConnection connection : this.connections) {
			connection.shutDown();
		}
	}
}
