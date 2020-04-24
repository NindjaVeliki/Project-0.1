package com.github.mehrabrahman.calc.io;

import java.util.List;

public interface Dao<E> {
	void insertAll(List<E> e);

	List<E> readAll();
}