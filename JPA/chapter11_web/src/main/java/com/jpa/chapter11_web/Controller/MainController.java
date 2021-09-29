package com.jpa.chapter11_web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	@RequestMapping("/")
	public String gotoMain(){
		return "index";
	}
}
