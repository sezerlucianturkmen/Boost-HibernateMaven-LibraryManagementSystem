package com.bilgeadam.utility;

import java.util.List;
import java.util.Optional;

public interface ICrud<T, ID> extends IRepository<T, ID> {

	<S extends T> S save(S entity); // tek kayýt ekleme ve güncelleme

	<S extends T> Iterable<S> save(Iterable<S> entities); // liste þeklinde

	void deleteById(ID id);

	void delete(T entity);

	Optional<T> findById(ID id);

	boolean existById(ID id);

	List<T> findAll();

	List<T> finByCollumnAndValue(String collumn, Object value);// verilen kolonu verilen deðre göre listeler

	List<T> findByEntity(T entity);

}