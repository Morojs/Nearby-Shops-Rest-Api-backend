package com.nearby.shops.dao;

import com.nearby.shops.models.Abonnement;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    public Optional<T> FindByID(Integer arg);
    public T Add(T arg);
    public void DeleteById(Integer arg);
    public T Update(T obj,Integer arg);
    public List<T> GetAll();

}
