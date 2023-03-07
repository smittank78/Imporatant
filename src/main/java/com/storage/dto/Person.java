package com.storage.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({"active","type","date","id"})
public class Person
{
	private int id;
	private String type;
	private boolean active;
	private Map<String ,String> info = new HashMap<>();
	/*
	 * hidden in response
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	private String hideFromUser;
	/*
	 * write from api only
	 */
	@JsonProperty(access = Access.READ_ONLY)
	private String showOnly;
	@JsonFormat(shape = Shape.STRING , pattern = "dd/MM/yyyy")
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getShowOnly() {
		return showOnly;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*
	 * type replaced with user_type
	 */
	@JsonGetter("user_type")
	public String getType() {
		return type;
	}
	@JsonSetter("user_type")
	public void setType(String type) {
		this.type = type;
	}
	/*
	 * response without "name" : {"a" : "a" , ...}
	 */
	@JsonAnyGetter
	public Map<String, String> getName() {
		return info;
	}
	/*
	 * request body without "name" : {"a" : "a" , ...}
	 * if any parameter not match is body it takes as map key-value
	 * instead of taking map as param take key and value
	 */
	@JsonAnySetter
	public void setName(String key,String value) {
		this.info.put(key, value);
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getHideFromUser() {
		return hideFromUser;
	}
	public void setHideFromUser(String hideFromUser) {
		this.hideFromUser = hideFromUser;
	}
	public String isShowOnly() {
		return showOnly;
	}
	public void setShowOnly(String showOnly) {
		this.showOnly = showOnly;
	}
}