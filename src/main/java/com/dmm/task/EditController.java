package com.dmm.task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditController {

	@RequestMapping("/edit")
	public String edit() {
		return "edit";
	}
}
