package com.dmm.task.data.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmm.task.data.entity.Tasks;



public interface TaskRepository extends JpaRepository<Tasks, Integer> {

	List<Tasks> findByDateBetween(LocalDateTime from,LocalDateTime to,String name);
	
	
	List<Tasks> findAllByDateBetween(LocalDateTime from,LocalDateTime to);
	
	
}
