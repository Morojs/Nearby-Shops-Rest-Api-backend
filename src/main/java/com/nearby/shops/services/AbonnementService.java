package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Abonnement;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AbonnementService implements CrudDao<Abonnement> {

    @Override
    public boolean add() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public List<Abonnement> getAll() {
        return null;
    }

    @Override
    public Abonnement getById() {
        return null;
    }
}
