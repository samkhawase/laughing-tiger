package org.java.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID")
	private Long tagId;
	
	@Column(name="TAGNAME")
	private String tagName;
	
	@ManyToMany(targetEntity=org.java.models.Task.class, mappedBy="tags")
	private List<Task> tasks;

	public Tag(String tagName) {
		super();
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
//	Note to future self: set this whenever you set the tag. 
//	private boolean tagCount; 
	
}
