package com.dmm.task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditController {

	@GetMapping("/main/edit/{id}(id=${task.id})")
	public String edit() {
		return "edit";
	}
}
