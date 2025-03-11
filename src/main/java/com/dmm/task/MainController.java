package com.dmm.task;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main")
	public String main(Model model) {
		// ListのListを用意
		List<List<LocalDate>> month = new LinkedList<>();

		// 1週間分のLocalDateを格納するList
		List<LocalDate> week = new LinkedList<LocalDate>();

//		LocalDate d;
//		if (date == null) {
//			d = LocalDate.now().withDayOfMonth(1);
//			;
//
//		} else {
//			d = date;
//		}

		// LocalDateで今の月の1日目を定義
		LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);

		// LocalDateで今の月の月末を定義
		LocalDate endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());

		// 曜日を表すDayOfWeekを取得
		DayOfWeek w = startOfMonth.getDayOfWeek();

		// 列挙型で曜日を数字に変換
		int dayOfWeekValue = w.getValue();

		final int number = 7;

		if (dayOfWeekValue != number) {
			// マイナスして前月分のLocalDateを求める
			startOfMonth = startOfMonth.minusDays(dayOfWeekValue);
		}

		boolean judge = false;
		while (!judge) {

			for (int j = 1; j <= number; j++) {

				week.add(startOfMonth);

				if (startOfMonth.equals(endOfMonth)) {
					judge = true;

				}
				startOfMonth = startOfMonth.plusDays(1);
			}

			month.add(week);
			week = new LinkedList<>();

		}

		model.addAttribute("month", month);

		return "main";
	}

}


