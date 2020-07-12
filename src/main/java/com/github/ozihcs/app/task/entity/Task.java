package com.github.ozihcs.app.task.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    private UUID id = UUID.randomUUID();
    private String title;
    private String description;
    @OneToOne
    @JoinColumn(name = "status_id", nullable = false)
    private TaskStatus status;
    private Date dateOfStart;
    private Date dateOfCompletion;
    @CreationTimestamp
    private Date createdAt;


    public Task(String title, Date dateOfCompletion, Date dateOfStart, String description) {
        this.title = title;
        this.dateOfCompletion = dateOfCompletion;
        this.dateOfStart = dateOfStart;
        this.description = description;
        this.status = TaskStatus.NEW();
    }

    public void changeTitle(String title) {
        this.setTitle(title);
    }

    public void changeDescription(String description) {
        this.setDescription(description);
    }

    public void changeDateOfStart(Date dateOfStart) {
        this.setDateOfStart(dateOfStart);
    }

    public void changeDateOfCompletion(Date dateOfCompletion) {
        this.setDateOfCompletion(dateOfCompletion);
    }

    public void done() {
        if (status.is(TaskStatus.DONE)) {
            return;
        }

        if (status.is(TaskStatus.DECLINED)) {
            return; // TODO: Add business logic exception
        }

        this.setStatus(TaskStatus.DONE());
    }

    public void declined() {
        if (status.is(TaskStatus.DECLINED)) {
            return;
        }

        if (status.is(TaskStatus.DONE)) {
            return; // TODO: Add business logic exception
        }

        this.setStatus(TaskStatus.DECLINED());
    }

}
