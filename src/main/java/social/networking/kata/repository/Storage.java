package social.networking.kata.repository;

import java.util.List;

public interface Storage<T> {
	
	public void save(String user, T data);
	
	public List<T> read(String user);

}
