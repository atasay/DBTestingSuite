package tests;

import db.interfaces.KeyValueConnection;
import tests.abstracts.AbstractKeyValueThreadedTest;
import tests.threads.KeyValueReadThread;
import tests.threads.KeyValueWriteThread;
import util.TestLog;

public class KeyValuePerformance extends AbstractKeyValueThreadedTest {

	public KeyValuePerformance(KeyValueConnection[] connections) {
		super(connections);
		// TODO Auto-generated constructor stub
	}
	
	public boolean testWrite(int n, int dataLength) {
		TestLog.log("KEY-VALUE WRITE PERFORMANCE TEST (" + threadCount + " threads)");
		
		try {
			
			Thread[] writeThreads = new KeyValueWriteThread[threadCount];
			for(int i = 0; i < threadCount; i++) {
				writeThreads[i] = new KeyValueWriteThread(i, connections[i], n/threadCount, dataLength);
			}
			
			for(int i = 0; i < threadCount; i++) {
				writeThreads[i].start();
			}
			
			long start = System.currentTimeMillis();
			
			for(int i = 0; i < threadCount; i++) {
				writeThreads[i].join();
			}
			
			long finish = System.currentTimeMillis();
			
			Long elapsed = new Long(finish - start);
			
			TestLog.log("Total write time: " + elapsed.toString() + " milliseconds (" + n + " requests)");
			TestLog.log("Write performance: " + (n*1000) / elapsed + " writes per sec");
			
			return true;
			
		} catch(Exception e) {
			TestLog.log(e.getMessage());
			return false;
		}
	}
	
	public boolean testRead(int n) {
		TestLog.log("KEY-VALUE READ PERFORMANCE TEST (" + threadCount + " threads)");
		
		try {
			
			Thread[] readThreads = new KeyValueReadThread[threadCount];
			for(int i = 0; i < threadCount; i++) {
				readThreads[i] = new KeyValueReadThread(i, connections[i], n/threadCount);
			}
			
			for(int i = 0; i < threadCount; i++) {
				readThreads[i].start();
			}
			
			long start = System.currentTimeMillis();
			
			for(int i = 0; i < threadCount; i++) {
				readThreads[i].join();
			}
			
			long finish = System.currentTimeMillis();
			
			Long elapsed = new Long(finish - start);
			
			TestLog.log("Total read time: " + elapsed.toString() + " milliseconds (" + n + " requests)");
			TestLog.log("Read performance: " + (n*1000) / elapsed + " reads per sec");
			
			return true;
			
		} catch(Exception e) {
			TestLog.log(e.getMessage());
			return false;
		}
	}

}
