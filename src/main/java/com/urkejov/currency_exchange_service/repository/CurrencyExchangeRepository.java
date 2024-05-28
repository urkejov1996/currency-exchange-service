package com.urkejov.currency_exchange_service.repository;

import com.urkejov.currency_exchange_service.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    @Query("select c from CurrencyExchange c where c.from = ?1 and c.to = ?2")
    CurrencyExchange findByFromAndTo(String from, String to);
}
