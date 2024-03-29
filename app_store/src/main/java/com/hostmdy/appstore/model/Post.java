package com.hostmdy.appstore.model;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
	
	private Long id;
	private Long user_id;
	private String image;
	private String title;
	private String description;
	private String release_date;
	private String app_link;
	private String min_req;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private List<String> tagIds;
	
	public Post() {
		
	}
	
	

	public Post(Long id, Long user_id, String image, String title, String description, String release_date,
			String app_link, String min_req) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.image = image;
		this.title = title;
		this.description = description;
		this.release_date = release_date;
		this.app_link = app_link;
		this.min_req = min_req;
	}



	public Post(Long id, Long user_id, String image, String title, String description, String release_date,
			String min_req, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.image = image;
		this.title = title;
		this.description = description;
		this.release_date = release_date;
		this.min_req = min_req;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	

	public Post(Long user_id, String image, String title, String description, String release_date,
			String min_req, String app_link) {
		super();
		this.user_id = user_id;
		this.image = image;
		this.title = title;
		this.description = description;
		this.release_date = release_date;
		this.min_req = min_req;
		this.app_link= app_link;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getMin_req() {
		return min_req;
	}

	public void setMin_req(String min_req) {
		this.min_req = min_req;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	

	public String getApp_link() {
		return app_link;
	}

	public void setApp_link(String app_link) {
		this.app_link = app_link;
	}

	public List<String> getTagIds() {
		return tagIds;
	}

	public void setTagIds(List<String> tagIds) {
		this.tagIds = tagIds;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", user_id=" + user_id + ", image=" + image + ", title=" + title + ", description="
				+ description + ", release_date=" + release_date + ", min_req=" + min_req + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	
	
	
}
