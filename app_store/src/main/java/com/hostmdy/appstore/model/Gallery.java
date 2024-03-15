package com.hostmdy.appstore.model;

public class Gallery {
	
	private Long id;
	private Long post_id;
	private String image;
	
	public Gallery() {
		
	}

	public Gallery(Long id, Long post_id, String image) {
		super();
		this.id = id;
		this.post_id = post_id;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPost_id() {
		return post_id;
	}

	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Gallery [id=" + id + ", post_id=" + post_id + ", image=" + image + "]";
	}
	
	
}
