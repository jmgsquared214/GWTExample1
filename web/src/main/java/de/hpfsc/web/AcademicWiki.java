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
public class AcademicWiki extends ListGridRecord  implements Serializable {
	
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
	public String pdf;
	@Column(name = "created_date")
	public String date;
	@Column(name = "articlename")
	public String articleName;
	@Column(name = "studentname")
	public String studentName;
	
	
	public String getResource() {
		return getAttributeAsString("resource");
	}
	public void setResource(String resource) {
		 setAttribute("resource", resource);;
	}
	public String getLink() {
		return getAttributeAsString("link");
	}
	public void setLink(String link) {
		 setAttribute("link", link);;
	}
	public String getPdf() {
		return getAttributeAsString("pdf");
	}
	public void setPdf(String pdf) {
		 setAttribute("pdf", pdf);;
	}
	public String getDate() {
		return getAttributeAsString("date");
	}
	public void setDate(String date) {
		 setAttribute("date", date);;
	}
	public String getArticleName() {
		return getAttributeAsString("articlename");
	}
	public void setArticleName(String articleName) {
		 setAttribute("articlename", articleName);;
	}
	public String getStudentName() {
		return getAttributeAsString("studentname");
	}
	public void setStudentName(String studentName) {
		 setAttribute("studentname", studentName);;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
