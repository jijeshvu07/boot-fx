package com.jo.sndp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LW_OFFICE_BARRIER")
public class OfficeBarrier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OFFICE_BARRIER_ID", nullable = false, length = 11)
	private long id;
	@Column(name = "PERIOD_FROM", nullable = false)
	private Date periodFrom;
	@Column(name = "PERIOD_TO", nullable = false)
	private Date periodTo;
	@Column(name = "GROUP_NAME", nullable = false)
	private String groupName;
	@Column(name = "ITEM_NAME", nullable = false)
	private String itemName;
	@Column(name = "SAKHA_NAME")
	private String sakhaName;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	@Column(name = "IS_DELETE", nullable = false)
	private boolean isDelete;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "officeBarrier", orphanRemoval = true)
	private List<OfficeBarrierDetails> details;

	public OfficeBarrier() {
		super();
	}

	public OfficeBarrier(long id, Date periodFrom, Date periodTo, String groupName, String itemName, String sakhaName,
			Date createdDate, boolean isDelete, List<OfficeBarrierDetails> details) {
		super();
		this.id = id;
		this.periodFrom = periodFrom;
		this.periodTo = periodTo;
		this.groupName = groupName;
		this.itemName = itemName;
		this.sakhaName = sakhaName;
		this.createdDate = createdDate;
		this.isDelete = isDelete;
		this.details = details;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPeriodFrom() {
		return periodFrom;
	}

	public void setPeriodFrom(Date periodFrom) {
		this.periodFrom = periodFrom;
	}

	public Date getPeriodTo() {
		return periodTo;
	}

	public void setPeriodTo(Date periodTo) {
		this.periodTo = periodTo;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSakhaName() {
		return sakhaName;
	}

	public void setSakhaName(String sakhaName) {
		this.sakhaName = sakhaName;
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

	public List<OfficeBarrierDetails> getDetails() {
		return details;
	}

	public void setDetails(List<OfficeBarrierDetails> details) {
		this.details = details;
	}

}
