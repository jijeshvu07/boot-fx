package com.jo.sndp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "LW_EDUCATION_QUALIFICATION")
public class EducationQualification implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 11)
	private long id;
	@Column(name = "QUALIFICATION", nullable = false)
	private String qualification;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	@Column(name = "IS_DELETE", nullable = false)
	private boolean isDelete;

	public EducationQualification() {
		super();
	}

	public EducationQualification(long id, String qualification, Date createdDate, boolean isDelete) {
		super();
		this.id = id;
		this.qualification = qualification;
		this.createdDate = createdDate;
		this.isDelete = isDelete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

}
