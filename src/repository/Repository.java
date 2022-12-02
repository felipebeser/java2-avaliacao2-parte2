package repository;

import java.util.List;

public interface Repository<T> {
	T get(String id);
	
	List<T> getAll();
	
	List<T> getAllByFirstLetter(String l);	
	
	void insert(T t);
	
	void update(T t);
	
	void delete(T t);
}
