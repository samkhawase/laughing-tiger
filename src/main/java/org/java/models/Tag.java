package org.java.models;

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
	
//	@Column(name="TAGNAME")
	
	@ManyToMany(targetEntity=org.java.models.Tag.class, mappedBy="tags")
	private String tagName;

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
