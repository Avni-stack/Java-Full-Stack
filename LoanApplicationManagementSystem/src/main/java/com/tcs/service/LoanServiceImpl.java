package com.tcs.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tcs.entity.Loan;
import com.tcs.exception.InvalidLoanAmountException;
import com.tcs.exception.LoanNotFoundException;
import com.tcs.repository.LoanRepository;
import com.tcs.util.AppConstant;

@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	LoanRepository loanRepository;
	
	public Loan addLoan(Loan loan) throws InvalidLoanAmountException 
	{
	    double amount = loan.getLoanAmount();
	    if (amount < 1 || amount > 5_000_000) 
	    {
	        throw new InvalidLoanAmountException(AppConstant.INVALID_LOAN_AMOUNT_MESSAGE);
	    }
	    loan.setStatus("PENDING");
	    return loanRepository.save(loan);
	}
	    
	@Override
	public List<Loan> getAllLoan() {
		return loanRepository.findAll();
	}
	@Override
	public Loan getLoanById(long id) throws LoanNotFoundException {
		return loanRepository.findById(id).orElseThrow(()->new LoanNotFoundException(AppConstant.LOAN_NOT_FOUND_MESSAGE));
	}
	@Override
	public Loan updateLoanById(long id, Loan loan) throws LoanNotFoundException {
		    
		Loan loan1=   loanRepository.findById(id).orElseThrow(()-> new LoanNotFoundException(AppConstant.LOAN_NOT_FOUND_MESSAGE));
		loan1.setApplicantName(loan.getApplicantName());  
		loan1.setLoanAmount(loan.getLoanAmount());
		loan1.setStatus(loan.getStatus());
		 loanRepository.save(loan1);
		return loan1;
	}
	
	public String deleteLoanById(long id) throws  LoanNotFoundException{
	   if(!loanRepository.existsById(id))
		    throw new LoanNotFoundException(AppConstant.LOAN_NOT_FOUND_MESSAGE);
	    loanRepository.deleteById(id);
		return "loan with the id :"+ id +" is deleted";
	}
}
