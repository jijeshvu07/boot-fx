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
@Table(name = "LW_SHG_DETAILS")
public class SelfHelpGroupDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 11)
	private long id;
	@ManyToOne
	@JoinColumn(name = "SHG_ID", nullable = false)
	private SelfHelpGroup selfHelpGroup;
	@Column(name = "MEMBER_CODE", nullable = false)
	private String memberCode;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	public SelfHelpGroupDetails() {
		super();
	}

	public SelfHelpGroupDetails(long id, SelfHelpGroup selfHelpGroup, String memberCode, Date createdDate) {
		super();
		this.id = id;
		this.selfHelpGroup = selfHelpGroup;
		this.memberCode = memberCode;
		this.createdDate = createdDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SelfHelpGroup getSelfHelpGroup() {
		return selfHelpGroup;
	}

	public void setSelfHelpGroup(SelfHelpGroup selfHelpGroup) {
		this.selfHelpGroup = selfHelpGroup;
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
