package com.github.ozihcs.app.task.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@Entity
public class TaskStatus {
    public static final String NEW = "new";
    public static final String DECLINED = "declined";
    public static final String DONE = "done";
    public static final List<String> VALID_STATUSES = Arrays.asList(NEW, DECLINED, DONE);

    @Id
    private UUID id;
    private String status;

    public TaskStatus(String status) {
        assert VALID_STATUSES.contains(status);

        this.status = status;
    }

    public static TaskStatus NEW() {
        return new TaskStatus(TaskStatus.NEW);
    }

    public static TaskStatus DECLINED() {
        return new TaskStatus(TaskStatus.DECLINED);
    }

    public static TaskStatus DONE() {
        return new TaskStatus(TaskStatus.DONE);
    }

    public boolean is(String status) {
        return this.status.equals(status);
    }
}
