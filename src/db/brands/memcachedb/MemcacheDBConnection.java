package db.brands.memcachedb;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;
import util.TestLog;
import db.interfaces.KeyValueConnection;

public class MemcacheDBConnection implements KeyValueConnection {
	
	protected MemcachedClient memcachedClient;

	public void initialize() {
		try {
			memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 21201));
			TestLog.log("MemcacheDB connection initialized.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String read(String key) {
		return (String) memcachedClient.get(key);
	}

	public void write(String key, String value) {
		memcachedClient.set(key, 0, value);
	}
	
	public void shutDown() {
		//memcachedClient.shutdown();
		TestLog.log("MemcacheDB connection shut down.");
	}

}
