package org.java.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	private Long taskId;
	
	private String taskName;

	
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	
}
