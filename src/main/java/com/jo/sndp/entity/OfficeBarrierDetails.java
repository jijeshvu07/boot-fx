package com.jo.sndp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LW_OFFICE_BARRIER_DETAILS")
public class OfficeBarrierDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 11)
	private long id;
	@ManyToOne
	@JoinColumn(name = "OFFICE_BARRIER_ID", nullable = false)
	private OfficeBarrier officeBarrier;
	@ManyToOne
	@JoinColumn(name = "DESIGNATION_ID", nullable = false)
	private Designation designation;
	@Column(name = "MEMBER_CODE", nullable = false)
	private String memberCode;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	public OfficeBarrierDetails() {
		super();
	}

	public OfficeBarrierDetails(long id, OfficeBarrier officeBarrier, Designation designation, String memberCode,
			Date createdDate) {
		super();
		this.id = id;
		this.officeBarrier = officeBarrier;
		this.designation = designation;
		this.memberCode = memberCode;
		this.createdDate = createdDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OfficeBarrier getOfficeBarrier() {
		return officeBarrier;
	}

	public void setOfficeBarrier(OfficeBarrier officeBarrier) {
		this.officeBarrier = officeBarrier;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
