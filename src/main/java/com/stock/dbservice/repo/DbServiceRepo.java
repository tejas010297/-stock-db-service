package com.stock.dbservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.dbservice.model.Quote;

public interface DbServiceRepo extends JpaRepository<Quote, Integer> {

  List<Quote> findByUserName(String userName);
}
