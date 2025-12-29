package com.tcs.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class helloworldcontroller {
	@GetMapping("/home")
   public ResponseEntity<String> home()
   {
	   String message="this is home page";
	   return new ResponseEntity<String>(message,HttpStatus.OK);
   }
	@GetMapping("/aboutus")
	   public String aboutus()
	   {
		   return "this is about us";
	   }
	@GetMapping("/addproduct")
	   public String addproduct()
	   {
		   return "add product accessed by admin only";
	   }
	@GetMapping("/viewallproduct")
	   public String viewallproduct()
	   {
		   return " accessed by admin and user";
	   }
	   
}
