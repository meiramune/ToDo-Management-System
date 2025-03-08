package com.dmm.task.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmm.task.data.entity.TaskRegister;



public interface TaskRegisterRepository extends JpaRepository<TaskRegister, Integer> {

}
