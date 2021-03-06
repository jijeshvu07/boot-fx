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
@Table(name = "LW_PANCHAYATH_OFFICE")
public class PanchayathOffice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 11)
	private long id;
	@Column(name = "PANCHAYATH_NAME", nullable = false)
	private String panchayathName;
	@ManyToOne
	@JoinColumn(name = "DISTRICT_ID", nullable = false)
	private District district;
	@ManyToOne
	@JoinColumn(name = "STATE_ID", nullable = false)
	private State state;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	@Column(name = "IS_DELETE", nullable = false)
	private boolean isDelete;

	public PanchayathOffice() {
		super();
	}

	public PanchayathOffice(long id, String panchayathName, District district, State state, Date createdDate,
			boolean isDelete) {
		super();
		this.id = id;
		this.panchayathName = panchayathName;
		this.district = district;
		this.state = state;
		this.createdDate = createdDate;
		this.isDelete = isDelete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPanchayathName() {
		return panchayathName;
	}

	public void setPanchayathName(String panchayathName) {
		this.panchayathName = panchayathName;
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
