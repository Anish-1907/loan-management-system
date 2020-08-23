package com.training.bms.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.training.bms.model.UserLoan;

import reactor.core.publisher.Flux;

@Repository
public interface LoanRepository extends ReactiveCrudRepository<UserLoan, Integer>{
	
	@Query("SELECT * FROM loans WHERE userId=:userId")
	public Flux<UserLoan> findByUserId(Integer userId);
   
}
