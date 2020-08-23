package com.training.bms.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.training.bms.handler.LoanHandler;

import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
public class LoanRouter {
	
	@Bean
	public RouterFunction<ServerResponse> getAllLoans(LoanHandler loanHandler){
		log.info("Inside get all Loans router function");

	  return RouterFunctions.route(GET("/loans").and(accept(MediaType.APPLICATION_JSON)), loanHandler::getLoanDetails)
			  .andRoute(GET("/users/loans/{userId}"), loanHandler::getLoanByUserId)
	          .andRoute(GET("/loans/{loanId}"), loanHandler::getLoanById)
	          .andRoute(POST("/loans").and(accept(MediaType.APPLICATION_JSON)), loanHandler::createLoan);
	}



}
