package com.github.ozihcs.app.task.commands.create;

import com.github.ozihcs.app.task.entity.Task;
import com.github.ozihcs.app.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskCommandHandler {
    @Autowired
    private TaskRepository taskRepository;

    public void handle(CreateTaskCommand command) {
        Task task = new Task(command.title, command.dateOfCompletion, command.dateOfStart, command.description);
        taskRepository.save(task);
    }
}
