import db.brands.memcachedb.ManyBrainMemcacheDBConnection;
import db.brands.memcachedb.MemcacheDBConnection;
import db.brands.redis.RedisConnection;
import tests.KeyValueCorrectness;
import tests.KeyValuePerformance;


public class DBTestingSuite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// REDIS TESTS
		/*KeyValueCorrectness keyValueCorrectness = new KeyValueCorrectness(new RedisConnection());
		keyValueCorrectness.initialize();
		keyValueCorrectness.test();
		keyValueCorrectness.shutDown();
		
		RedisConnection[] connections = new RedisConnection[2];
		for(int i = 0; i < 2; i++) connections[i] = new RedisConnection();
		KeyValuePerformance keyValuePerformance = new KeyValuePerformance(connections);
		keyValuePerformance.initialize();
		keyValuePerformance.testWrite(10000, 32);
		keyValuePerformance.testRead(10000);
		keyValuePerformance.shutDown();*/
		
		// MEMCACHEDB TESTS (Client 1)
		/*KeyValueCorrectness keyValueCorrectness = new KeyValueCorrectness(new MemcacheDBConnection());
		keyValueCorrectness.initialize();
		keyValueCorrectness.test();
		keyValueCorrectness.shutDown();
		
		MemcacheDBConnection[] connections = new MemcacheDBConnection[10];
		for(int i = 0; i < 10; i++) connections[i] = new MemcacheDBConnection();
		KeyValuePerformance keyValuePerformance = new KeyValuePerformance(connections);
		keyValuePerformance.initialize();
		keyValuePerformance.testWrite(100000, 32);
		keyValuePerformance.testRead(100000);
		keyValuePerformance.shutDown();*/
		
		// MEMCACHEDB TESTS (Client 2)
		KeyValueCorrectness keyValueCorrectness = new KeyValueCorrectness(new ManyBrainMemcacheDBConnection());
		keyValueCorrectness.initialize();
		keyValueCorrectness.test();
		keyValueCorrectness.shutDown();
		
		ManyBrainMemcacheDBConnection[] connections = new ManyBrainMemcacheDBConnection[10];
		for(int i = 0; i < 10; i++) connections[i] = new ManyBrainMemcacheDBConnection();
		KeyValuePerformance keyValuePerformance = new KeyValuePerformance(connections);
		keyValuePerformance.initialize();
		keyValuePerformance.testWrite(100000, 32);
		keyValuePerformance.testRead(100000);
		keyValuePerformance.shutDown();
		
	}

}
