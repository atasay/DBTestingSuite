package db.brands.memcachedb;

import com.manybrain.persistent.MemCacheClient;

import util.TestLog;
import db.interfaces.KeyValueConnection;

public class ManyBrainMemcacheDBConnection implements KeyValueConnection {
	
	protected MemCacheClient memcachedClient;

	public void initialize() {
		String[] servers = new String[] { "127.0.0.1:21201" };
		int weights[] = new int[] { 3 };
		try {
			TestLog.log("MemcacheDB connection initialized.");
			memcachedClient = new MemCacheClient(servers, weights);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String read(String key) {
		return (String) memcachedClient.get(key);
	}

	public void write(String key, String value) {
		memcachedClient.set(key, value);
	}
	
	public void shutDown() {
		TestLog.log("MemcacheDB connection shut down.");
	}

}
