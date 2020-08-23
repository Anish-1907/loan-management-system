package com.training.bms.model;


import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Table("loans")
public class UserLoan {
	
	@Id
	@Column("loanId")
	private Integer loanId;
	@Column("userId")
	private Integer userId;
	@Column("loan_type")
	private String  loanType;
	@Column("loan_amount")
	private Integer loanAmount;
	@Column("loan_date")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate loanDate;
	@Column("rate_of_interest")
	private Integer rateOfInterest;
	@Column("loan_duration")
	private Integer loanDuration;
	
	public UserLoan() {
	}

	public UserLoan(Integer loanId, Integer userId, String loanType, Integer loanAmount, LocalDate loanDate,
			Integer rateOfInterest, Integer loanDuration) {
		super();
		this.loanId = loanId;
		this.userId = userId;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.loanDate = loanDate;
		this.rateOfInterest = rateOfInterest;
		this.loanDuration = loanDuration;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Integer getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public Integer getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Integer rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Integer getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}

	@Override
	public String toString() {
		return "UserLoan [loanId=" + loanId + ", userId=" + userId + ", loanType=" + loanType + ", loanAmount="
				+ loanAmount + ", loadDate=" + loanDate + ", rateOfInterest=" + rateOfInterest + ", loanDuration="
				+ loanDuration + "]";
	}
	
	

}
