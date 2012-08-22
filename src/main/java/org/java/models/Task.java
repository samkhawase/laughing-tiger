package org.java.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "Task.Query1", query = "Select t from Task t") })
@Entity
@Table(name = "task")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long taskId;

	@Column(name = "NAME", length = 100, nullable = false)
	private String taskName;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "PRIORITY")
	private int priority;

	@Column(name = "IS_COMPLETED")
	private boolean isCompleted;

	@ManyToMany(targetEntity = org.java.models.Tag.class)
	private List<Tag> tags;

	/* Constructors */
	public Task(String taskName, Date createdDate, int priority,
			boolean isCompleted, List<Tag> tags) {
		super();
		this.taskName = taskName;
		this.createdDate = createdDate;
		this.priority = priority;
		this.isCompleted = isCompleted;
		this.tags = tags;
	}

	public Task() {
	}

	/* getters-setters */

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
