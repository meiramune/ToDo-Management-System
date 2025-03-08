package com.dmm.task.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.dmm.task.data.entity.TaskRegister;
import com.dmm.task.data.repository.TaskRegisterRepository;
import com.dmm.task.form.RegisterForm;


@Controller
public class TaskRegisterController {
	
	@Autowired
	private TaskRegisterRepository repo;

	/**
	 * 投稿を作成.
	 * 
	 * @param postForm 送信データ
	 * @param user     ユーザー情報
	 * @return 遷移先
	 */
	@PostMapping("/create")
	public String create(@Validated RegisterForm registerForm, BindingResult bindingResult,
			@AuthenticationPrincipal AccountUserDetails user, Model model) {
		// バリデーションの結果、エラーがあるかどうかチェック
		if (bindingResult.hasErrors()) {
			// エラーがある場合は投稿登録画面を返す
			List<TaskRegister> list = repo.findAll();
			model.addAttribute("posts", list);
			model.addAttribute("postForm", registerForm);
			return "/posts";
		}

		TaskRegister tr = new TaskRegister();
		tr.setName(registerForm.getName());
		tr.setTitle(registerForm.getTitle());
		tr.setText(registerForm.getText());
		tr.setDate(LocalDateTime.now());

		repo.save(tr);

		return "redirect:/main";
}
}


//日付をクリックするとタスクの登録画面へ遷移する



