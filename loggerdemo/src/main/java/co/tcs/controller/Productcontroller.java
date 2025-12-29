package co.tcs.controller;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.classic.Logger;

@RestController
public class Productcontroller {
	
  Logger logger= (Logger)LoggerFactory.getLogger(Productcontroller.class);
	
	@GetMapping("/home")
	public String home()
	{
		logger.info("this is info message");
		return "this is home";
	}
	@GetMapping("/aboutus")
    public String aboutUs()
    {
		logger.warn("Warning....");
    	return "this is about us";
    }
}
