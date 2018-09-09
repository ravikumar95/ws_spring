package com.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/loginsubmit")
	public String loginsubmit(@RequestParam Map<String, Object> model) {
		System.out.println("loginsubmit params:"+model.get("txt_name"));
		model.put("name", model.get("txt_name"));
		return "loginsubmit";
	}
	
	 

}