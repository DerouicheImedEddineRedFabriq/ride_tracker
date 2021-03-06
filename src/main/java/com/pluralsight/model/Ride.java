package com.pluralsight.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Ride {

	private Integer id;
	@NotNull
	private String name;
	@Min(100)
	private int duration;

	public int getDuration() {
		return duration;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
