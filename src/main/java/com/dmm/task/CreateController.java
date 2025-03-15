package com.dmm.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dmm.task.data.entity.Tasks;
import com.dmm.task.data.repository.TaskRepository;
import com.dmm.task.form.TaskForm;
import com.dmm.task.service.AccountUserDetails;

@Controller
public class CreateController {
	@Autowired
	private TaskRepository repo;

	@GetMapping("/main/create/{date}")
	public String create() {

		return "create";

	}

	@PostMapping("/main/create")
	public String create(@Validated TaskForm taskForm, @AuthenticationPrincipal AccountUserDetails user, Model model,
			BindingResult bindingResult) {

		// バリデーションの結果、エラーがあるかどうかチェック
		if (bindingResult.hasErrors()) {
			// エラーがある場合は投稿登録画面を返す
			List<Tasks> list = repo.findAll();
			model.addAttribute("tasks", list);
			return "/main";
		}

		Tasks taskRegister = new Tasks();

		taskRegister.setName(user.getName());
		taskRegister.setText(taskForm.getText());
		taskRegister.setTitle(taskForm.getTitle());
		taskRegister.setDate(taskForm.getDate().atStartOfDay());
		taskRegister.setDone(false);

		repo.save(taskRegister);

		return "redirect:/main";
	}
}
