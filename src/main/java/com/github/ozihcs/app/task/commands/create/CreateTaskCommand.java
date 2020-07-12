package com.github.ozihcs.app.task.commands.create;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CreateTaskCommand {
    public String title;
    public Date dateOfCompletion;
    public Date dateOfStart;
    public String description;
}
