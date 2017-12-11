package com.jyothi.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="academicwiki")
public class AcademicWiki  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AcademicWiki(String resource)
	{
		this.resource=resource;
	}
	public AcademicWiki()
	{
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "resource")
	public String resource;
	@Column(name = "link")
	public String link;
	@Column(name = "pdfname")
	public String pdfname;
	@Column(name = "articlename")
	public String articlename;
	@Column(name = "studentname")
	public String studentname;
	@Column(name = "subject")
public String 	subject;
@Transient
	public boolean 	Delete;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getResource() {
	return resource;
}
public void setResource(String resource) {
	this.resource = resource;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getPdfname() {
	return pdfname;
}
public void setPdfname(String pdfname) {
	this.pdfname = pdfname;
}
public String getArticlename() {
	return articlename;
}
public void setArticlename(String articlename) {
	this.articlename = articlename;
}
public String getStudentname() {
	return studentname;
}
public void setStudentname(String studentname) {
	this.studentname = studentname;
}
public boolean isDelete() {
	return Delete;
}
public void setDelete(boolean delete) {
	Delete = delete;
}
	
	
}
