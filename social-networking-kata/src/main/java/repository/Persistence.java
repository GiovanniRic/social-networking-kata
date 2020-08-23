package repository;

import java.util.List;

interface Persistence<T> {
	
	public void save(String user, T post);
	
	public List<T> read(String user);

}
