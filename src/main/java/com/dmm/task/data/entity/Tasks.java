package com.dmm.task.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//Getter、Setterを省略するためのLombokのアノテーション
@Data
//データベースのテーブルと対応するJavaオブジェクト
@Entity
public class Tasks {
	// userテーブルのプライマリーキーidに付けるアノテーション
	@Id
	// idがMySQLのauto_incrementの場合、自動生成させるためにアノテーションを付ける
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String text;
	private LocalDateTime date;
	private String name;
	
	}
