package com.dmm.task.form;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskForm {

	private String title;
	private String text;
	private LocalDateTime date;
	private String name;
	private boolean done;
}