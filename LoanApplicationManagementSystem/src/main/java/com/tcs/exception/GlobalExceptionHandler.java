package com.tcs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler 
{

	
	@ExceptionHandler(value = LoanNotFoundException.class)
	public ErrorInfo handleExceptionForId(LoanNotFoundException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setHttpStatus(HttpStatus.NOT_FOUND);
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return errorInfo;
	}
	
	@ExceptionHandler(value = InvalidLoanAmountException.class)
	public String handleExceptionForAge(InvalidLoanAmountException exception)
	{
		return exception.getMessage();
	}
}