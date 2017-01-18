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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LW_SHG")
public class SelfHelpGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SHG_ID", nullable = false, length = 11)
	private long id;
	@ManyToOne
	@JoinColumn(name = "UNION_ID", nullable = false)
	private Union union;
	@ManyToOne
	@JoinColumn(name = "SAKHA_ID", nullable = false)
	private SakhaDetails sakhaDetails;
	@Column(name = "SHG_NAME", nullable = false)
	private String shgName;
	@Column(name = "PLACE", nullable = false)
	private String place;
	@Column(name = "CONVEENER_CODE", nullable = false)
	private String conveenerCode;
	@Column(name = "JOINT_CONVEENER_CODE", nullable = false)
	private String jointConveenerCode;
	@Column(name = "PERIOD_FROM", nullable = false)
	private Date periodFrom;
	@Column(name = "PERIOD_TO", nullable = false)
	private Date periodto;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	@Column(name = "IS_DELETE", nullable = false)
	private boolean isDelete;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "selfHelpGroup", orphanRemoval = true)
	private List<SelfHelpGroupDetails> details;

	public SelfHelpGroup() {
		super();
	}

	public SelfHelpGroup(long id, Union union, SakhaDetails sakhaDetails, String shgName, String place,
			String conveenerCode, String jointConveenerCode, Date periodFrom, Date periodto, Date createdDate,
			boolean isDelete, List<SelfHelpGroupDetails> details) {
		super();
		this.id = id;
		this.union = union;
		this.sakhaDetails = sakhaDetails;
		this.shgName = shgName;
		this.place = place;
		this.conveenerCode = conveenerCode;
		this.jointConveenerCode = jointConveenerCode;
		this.periodFrom = periodFrom;
		this.periodto = periodto;
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

	public Union getUnion() {
		return union;
	}

	public void setUnion(Union union) {
		this.union = union;
	}

	public SakhaDetails getSakhaDetails() {
		return sakhaDetails;
	}

	public void setSakhaDetails(SakhaDetails sakhaDetails) {
		this.sakhaDetails = sakhaDetails;
	}

	public String getShgName() {
		return shgName;
	}

	public void setShgName(String shgName) {
		this.shgName = shgName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getConveenerCode() {
		return conveenerCode;
	}

	public void setConveenerCode(String conveenerCode) {
		this.conveenerCode = conveenerCode;
	}

	public String getJointConveenerCode() {
		return jointConveenerCode;
	}

	public void setJointConveenerCode(String jointConveenerCode) {
		this.jointConveenerCode = jointConveenerCode;
	}

	public Date getPeriodFrom() {
		return periodFrom;
	}

	public void setPeriodFrom(Date periodFrom) {
		this.periodFrom = periodFrom;
	}

	public Date getPeriodto() {
		return periodto;
	}

	public void setPeriodto(Date periodto) {
		this.periodto = periodto;
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

	public List<SelfHelpGroupDetails> getDetails() {
		return details;
	}

	public void setDetails(List<SelfHelpGroupDetails> details) {
		this.details = details;
	}

}
