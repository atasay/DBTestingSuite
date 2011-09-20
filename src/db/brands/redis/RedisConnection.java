package db.brands.redis;

import org.jredis.JRedis;
import org.jredis.RedisException;
import org.jredis.ri.alphazero.JRedisClient;
import org.jredis.ri.alphazero.support.Encode;

import util.TestLog;
import db.interfaces.KeyValueConnection;

public class RedisConnection implements KeyValueConnection {
	
	protected JRedis jredis;

	public void initialize() {
		jredis = new JRedisClient();
		TestLog.log("Redis connection initialized.");
	}

	public String read(String key) {
		try {
			return Encode.toStr(jredis.get(key));
		} catch(RedisException e) {
			TestLog.log("ERROR: Couldn't read key!");
			return "";
		}
	}

	public void write(String key, String value) {
		try {
			jredis.set(key, value);
		} catch(RedisException e) {
			TestLog.log("ERROR: Couldn't write key/value!");
		}
	}
	
	public void shutDown() {
		jredis.quit();
		TestLog.log("Redis connection shut down.");
	}

}
