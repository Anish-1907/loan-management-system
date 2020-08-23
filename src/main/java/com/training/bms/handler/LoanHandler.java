package com.training.bms.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.training.bms.exception.ErrorResponse;
import com.training.bms.model.UserLoan;
import com.training.bms.repository.LoanRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoanHandler {

	@Autowired
	LoanRepository loanRepository;

	public Mono<ServerResponse> getLoanDetails(ServerRequest request) {

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(loanRepository.findAll(),
				UserLoan.class);
	}

	public Mono<ServerResponse> getLoanByUserId(ServerRequest request) {

		Integer userId = Integer.parseInt(request.pathVariable("userId"));
		log.info("Inside get loan by UserId fucniton userId::::::" + userId);
		Mono<ServerResponse> fallback = Mono.error(new ErrorResponse("User Not Found",404));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(loanRepository.findByUserId(userId),
				UserLoan.class).switchIfEmpty(fallback);
				
				
						
		
	}

	public Mono<ServerResponse> getLoanById(ServerRequest request) {

		Integer loanId = Integer.parseInt(request.pathVariable("loanId"));
		log.info("Inside get loan by UserId fucniton userId::::::" + loanId);
		
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(loanRepository.findById(loanId),
				UserLoan.class);
	}
	
	public Mono<ServerResponse> createLoan(ServerRequest request) {

		Mono<UserLoan> userLoan = request.bodyToMono(UserLoan.class);
		log.info("Inside createLoan::::::" + userLoan.toString());
		return userLoan.flatMap(loan -> ServerResponse.status(201).contentType(MediaType.APPLICATION_JSON).body(loanRepository.save(loan),
				UserLoan.class))
				.onErrorResume(error -> ServerResponse.badRequest().build());
	}


}
