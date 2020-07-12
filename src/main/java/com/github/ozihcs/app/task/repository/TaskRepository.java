package com.github.ozihcs.app.task.repository;

import com.github.ozihcs.app.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}