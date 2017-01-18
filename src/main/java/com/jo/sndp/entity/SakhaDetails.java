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
@Table(name = "LW_SAKHA_DETAIL")
public class SakhaDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 11)
	private long id;
	@ManyToOne
	@JoinColumn(name = "UNION_ID", nullable = false)
	private Union union1;
	@Column(name = "SAKHA_NAME", nullable = false)
	private String sakhaName;
	@Column(name = "SAKHA_CODE", nullable = false)
	private String sakhaCode;
	@Column(name = "PLACE", nullable = false)
	private String place;
	@Column(name = "MEMBERS_COUNT_MALE")
	private int memberCountMale;
	@Column(name = "MEMBERS_COUNT_FEMALE")
	private int memberCountFeMale;
	@Column(name = "DATE_COMMENCEMENT", nullable = false)
	private Date dateCommencement;
	@Column(name = "STATUS", nullable = false)
	private String status;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	@Column(name = "IS_DELETE", nullable = false)
	private boolean isDelete;

	public SakhaDetails() {
		super();
	}

	public SakhaDetails(long id, Union union1, String sakhaName, String sakhaCode, String place, int memberCountMale,
			int memberCountFeMale, Date dateCommencement, String status, Date createdDate, boolean isDelete) {
		super();
		this.id = id;
		this.union1 = union1;
		this.sakhaName = sakhaName;
		this.sakhaCode = sakhaCode;
		this.place = place;
		this.memberCountMale = memberCountMale;
		this.memberCountFeMale = memberCountFeMale;
		this.dateCommencement = dateCommencement;
		this.status = status;
		this.createdDate = createdDate;
		this.isDelete = isDelete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Union getUnion() {
		return union1;
	}

	public void setUnion(Union unuion) {
		this.union1 = unuion;
	}

	public String getSakhaName() {
		return sakhaName;
	}

	public void setSakhaName(String sakhaName) {
		this.sakhaName = sakhaName;
	}

	public String getSakhaCode() {
		return sakhaCode;
	}

	public void setSakhaCode(String sakhaCode) {
		this.sakhaCode = sakhaCode;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getMemberCountMale() {
		return memberCountMale;
	}

	public void setMemberCountMale(int memberCountMale) {
		this.memberCountMale = memberCountMale;
	}

	public int getMemberCountFeMale() {
		return memberCountFeMale;
	}

	public void setMemberCountFeMale(int memberCountFeMale) {
		this.memberCountFeMale = memberCountFeMale;
	}

	public Date getDateCommencement() {
		return dateCommencement;
	}

	public void setDateCommencement(Date dateCommencement) {
		this.dateCommencement = dateCommencement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
