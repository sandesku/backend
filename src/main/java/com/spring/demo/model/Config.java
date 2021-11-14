package com.spring.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "demo_config")
public class Config extends AbstractModel{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "value", nullable = false)
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
