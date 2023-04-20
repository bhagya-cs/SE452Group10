package com.group10.se452_g10.payment;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    @Override
    List<PaymentMethod> findAll(Sort sort);

    @Override
    List<PaymentMethod> findAllById(Iterable<Long> longs);

    @Override
    void deleteAll();

    @Override
    void delete(PaymentMethod entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    long count();

    @Override
    boolean existsById(Long aLong);




}
