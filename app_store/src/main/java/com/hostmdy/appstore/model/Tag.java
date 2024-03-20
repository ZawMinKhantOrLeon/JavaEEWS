package com.hostmdy.appstore.model;

public class Tag {
	
	private Long id;
	private String name;
	
	public Tag() {
		
	}
	
	public Tag(String name) {
		this.name= name;
	}
	public Tag(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
