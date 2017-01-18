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
@Table(name = "LW_UNION")
public class Union implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 11)
	private long id;
	@Column(name = "UNION_NAME", nullable = false)
	private String unionName;
	@Column(name = "UNION_CODE", nullable = false)
	private String unionCode;
	@ManyToOne
	@JoinColumn(name = "DISTRICT_ID", nullable = false)
	private District district;
	@ManyToOne
	@JoinColumn(name = "STATE_ID", nullable = false)
	private State state;
	@Column(name = "EMAILID", nullable = false)
	private String emailId;
	@ManyToOne
	@JoinColumn(name = "POST_OFFICE_ID", nullable = false)
	private PostOffice postOffice;
	@Column(name = "BUILDING_NO", nullable = false)
	private String buildingNo;
	@Column(name = "LAND_PHONE_1")
	private String landPhone1;
	@Column(name = "LAND_PHONE_2")
	private String landPhone2;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	@Column(name = "IS_DELETE", nullable = false)
	private boolean isDelete;

	public Union() {
		super();
	}

	public Union(long id, String unionName, String unionCode, District district, State state, String emailId,
			PostOffice postOffice, String buildingNo, String landPhone1, String landPhone2, Date createdDate,
			boolean isDelete) {
		super();
		this.id = id;
		this.unionName = unionName;
		this.unionCode = unionCode;
		this.district = district;
		this.state = state;
		this.emailId = emailId;
		this.postOffice = postOffice;
		this.buildingNo = buildingNo;
		this.landPhone1 = landPhone1;
		this.landPhone2 = landPhone2;
		this.createdDate = createdDate;
		this.isDelete = isDelete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	public String getUnionCode() {
		return unionCode;
	}

	public void setUnionCode(String unionCode) {
		this.unionCode = unionCode;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public PostOffice getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(PostOffice postOffice) {
		this.postOffice = postOffice;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getLandPhone1() {
		return landPhone1;
	}

	public void setLandPhone1(String landPhone1) {
		this.landPhone1 = landPhone1;
	}

	public String getLandPhone2() {
		return landPhone2;
	}

	public void setLandPhone2(String landPhone2) {
		this.landPhone2 = landPhone2;
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
