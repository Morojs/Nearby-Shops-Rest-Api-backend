package com.nearby.shops.dao;

import java.util.List;

public interface CrudDao<T> {
    public boolean add();
    public boolean delete();
    public boolean update();
    public List<T> getAll();
    public T getById();
}
