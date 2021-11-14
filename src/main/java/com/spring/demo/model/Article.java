package com.spring.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "demo_article")
public class Article extends AbstractModel {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "headline", nullable = false)
	private String headline;
	
	@Column(name = "overview", nullable = false)
	private String overview;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name="article_id")
	@OrderColumn(name="article_order")
	private List<Body> bodyList;
	
	@Column(name = "conclusion", nullable = false)
	private String conclusion;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public List<Body> getBodyList() {
		return bodyList;
	}

	public void setBodyList(List<Body> bodyList) {
		this.bodyList = bodyList;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
}
