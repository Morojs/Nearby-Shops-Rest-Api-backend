package com.nearby.shops.dao;

import com.nearby.shops.models.Abonnement;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    public Optional<T> findByID(Integer arg);
    public T add(T arg);
    public void deleteById(Integer arg);
    public T update(T obj,Integer arg);
    public List<T> getAll();

}
