package db.interfaces;

public interface KeyValueConnection {
	
	public void initialize();
	
	public void write(String key, String value);
	
	public String read(String key);
	
	public void shutDown();
}
