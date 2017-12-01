package de.hpfsc.web;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.smartgwt.client.widgets.grid.ListGridRecord;

@Entity
@Table(name="academicwiki")
public class AcademicWikiModel  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AcademicWikiModel(String resource)
	{
		this.resource=resource;
	}
	public AcademicWikiModel()
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
	public String pdf;
	@Column(name = "created_date")
	public String date;
	@Column(name = "articlename")
	public String articleName;
	@Column(name = "studentname")
	public String studentName;
	
	
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
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
