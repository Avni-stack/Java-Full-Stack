package com.tcs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.entity.Loan;
import com.tcs.exception.InvalidLoanAmountException;
import com.tcs.exception.LoanNotFoundException;
import com.tcs.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController 
{

		@Autowired
		LoanService loanService;
		@PostMapping("/add")
		public Loan addLoan(@RequestBody Loan loan) throws InvalidLoanAmountException
		{
			return loanService.addLoan(loan);
		}
		
		@GetMapping("/view")
		public List<Loan> getAllLoans()
		{
			return loanService.getAllLoan();
		}
		
		@GetMapping("/view/{id}")
		public Loan getLoanById(@PathVariable long id) throws LoanNotFoundException
		{
			return loanService.getLoanById(id);
		}
		
		@PutMapping("/{id}/update")
		public Loan updateLoanById(@PathVariable long id,@RequestBody Loan loan)throws  LoanNotFoundException
		{
			return loanService.updateLoanById(id, loan);
		}
		
		@DeleteMapping("/{id}/delete")
		public String deleteLoanById(@PathVariable long id) throws LoanNotFoundException
		{
			return loanService.deleteLoanById(id);
		}
}
