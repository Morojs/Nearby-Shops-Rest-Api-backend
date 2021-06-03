package com.nearby.shops.repositories;

import com.nearby.shops.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
