package com.dmm.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateController {

	@RequestMapping("/create")
	public String create() {
		return "create";
	}
	
	
	
	
}
