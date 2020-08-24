package repository;

import java.util.List;

interface Storage<T> {
	
	public void save(String user, T data);
	
	public List<T> read(String user);

}
