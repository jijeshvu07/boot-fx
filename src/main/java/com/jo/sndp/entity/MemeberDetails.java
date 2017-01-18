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
@Table(name = "LW_MEMBER_DETAILS")
public class MemeberDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 11)
	private long id;
	@Column(name = "MEMBER_CODE", nullable = false)
	private String memberCode;
	@Column(name = "MEMBER_NAME", nullable = false)
	private String memberName;
	@ManyToOne
	@JoinColumn(name = "RELATION_SHIP_ID", nullable = false)
	private RelationShip relationShip;
	@ManyToOne
	@JoinColumn(name = "BLOOD_GROUP_ID", nullable = false)
	private BloodGroup bloodGroup;
	@Column(name = "DOB", nullable = false)
	private Date dob;
	@ManyToOne
	@JoinColumn(name = "QUALIFICATION_ID", nullable = false)
	private EducationQualification educationQualification;
	@ManyToOne
	@JoinColumn(name = "PHYSICAL_STATUS_ID", nullable = false)
	private PhysicalStatus physicalStatus;
	@ManyToOne
	@JoinColumn(name = "MARITAL_STATUS_ID", nullable = false)
	private MaritalStatus maritalStatus;
	@ManyToOne
	@JoinColumn(name = "GENDER_ID", nullable = false)
	private Gender gender;
	@ManyToOne
	@JoinColumn(name = "JOB_ID", nullable = false)
	private Job job;
	@Column(name = "PHOTO", nullable = false)
	private byte[] photo;
	@Column(name = "AADHAAR_NO")
	private String adhaarNo;
	@Column(name = "ELECTION_ID_NO")
	private String electionIdNo;
	@Column(name = "PAN_NO")
	private String panNo;
	@Column(name = "DRIVING_LICENCE_NO")
	private String drivingLicenceNo;
	@Column(name = "MOBILE_1")
	private String mobile1;
	@Column(name = "MOBILE_2")
	private String mobile2;
	@Column(name = "EMAIL_ID", nullable = false)
	private String emailId;
	@ManyToOne
	@JoinColumn(name = "MEMEBER_ID", nullable = false)
	private Member member;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	@Column(name = "IS_DELETE", nullable = false)
	private boolean isDelete;

	public MemeberDetails() {
		super();
	}

	public MemeberDetails(long id, String memberCode, String memberName, RelationShip relationShip,
			BloodGroup bloodGroup, Date dob, EducationQualification educationQualification,
			PhysicalStatus physicalStatus, MaritalStatus maritalStatus, Gender gender, Job job, byte[] photo,
			String adhaarNo, String electionIdNo, String panNo, String drivingLicenceNo, String mobile1, String mobile2,
			String emailId, Member member, Date createdDate, boolean isDelete) {
		super();
		this.id = id;
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.relationShip = relationShip;
		this.bloodGroup = bloodGroup;
		this.dob = dob;
		this.educationQualification = educationQualification;
		this.physicalStatus = physicalStatus;
		this.maritalStatus = maritalStatus;
		this.gender = gender;
		this.job = job;
		this.photo = photo;
		this.adhaarNo = adhaarNo;
		this.electionIdNo = electionIdNo;
		this.panNo = panNo;
		this.drivingLicenceNo = drivingLicenceNo;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.emailId = emailId;
		this.member = member;
		this.createdDate = createdDate;
		this.isDelete = isDelete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public RelationShip getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(RelationShip relationShip) {
		this.relationShip = relationShip;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public EducationQualification getEducationQualification() {
		return educationQualification;
	}

	public void setEducationQualification(EducationQualification educationQualification) {
		this.educationQualification = educationQualification;
	}

	public PhysicalStatus getPhysicalStatus() {
		return physicalStatus;
	}

	public void setPhysicalStatus(PhysicalStatus physicalStatus) {
		this.physicalStatus = physicalStatus;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getAdhaarNo() {
		return adhaarNo;
	}

	public void setAdhaarNo(String adhaarNo) {
		this.adhaarNo = adhaarNo;
	}

	public String getElectionIdNo() {
		return electionIdNo;
	}

	public void setElectionIdNo(String electionIdNo) {
		this.electionIdNo = electionIdNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getDrivingLicenceNo() {
		return drivingLicenceNo;
	}

	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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
