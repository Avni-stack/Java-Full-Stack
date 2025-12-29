package com.tcs.service;

import java.util.List;

import com.tcs.entity.Loan;
import com.tcs.exception.InvalidLoanAmountException;
import com.tcs.exception.LoanNotFoundException;

public interface LoanService {
		 public Loan addLoan(Loan loan) throws InvalidLoanAmountException;
		 public List<Loan> getAllLoan();
		 public Loan getLoanById(long id) throws LoanNotFoundException;
		 public Loan updateLoanById(long id, Loan loan) throws LoanNotFoundException;
		 public String deleteLoanById(long id)throws LoanNotFoundException;
		 
		 
	}
