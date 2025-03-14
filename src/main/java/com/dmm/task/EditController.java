package com.dmm.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dmm.task.data.entity.Tasks;
import com.dmm.task.data.repository.TaskRepository;
import com.dmm.task.form.TaskForm;
import com.dmm.task.service.AccountUserDetails;


@Controller
public class EditController {

	@Autowired
	private TaskRepository repo;

	@GetMapping("/main/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		//このリポジトリを使用することでデータの検索
		Tasks task = repo.findById(id).orElse(null);
		if (task != null) {
			model.addAttribute("task", task);

			return "edit";

		}
		return "redirect:/error";
	}
	//更新、削除ボタンの遷移画面、カレンダー上にチェックマーク（✅
	@PostMapping("/main/edit/{id}")
	public String edit(@Validated TaskForm taskForm, 
			@AuthenticationPrincipal AccountUserDetails user, Model model,BindingResult bindingResult) {
		Tasks task = new Tasks();
		task.setId(taskForm.getId());
		task.setName(user.getName());
		task.setText(taskForm.getText());
		task.setTitle(taskForm.getTitle());
		task.setDate(taskForm.getDate().atStartOfDay());
		
		task.setDone(false);

		repo.save(task);

		return "redirect:/main";
	}
	
		@PostMapping("/main/delete/{id}")
		public String delete(@PathVariable Integer id) {
			repo.deleteById(id);
			return "redirect:/main";
}
}
