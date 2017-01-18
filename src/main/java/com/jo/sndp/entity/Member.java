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
@Table(name = "LW_MEMBER")
public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 11)
	private long id;
	@Column(name = "MEMBER_NAME", nullable = false)
	private String memberName;
	@Column(name = "HOUSE_NO", nullable = false)
	private String houseNo;
	@Column(name = "MEMEBER_CODE", nullable = false)
	private String memeberCode;
	@ManyToOne
	@JoinColumn(name = "UNION_ID", nullable = false)
	private Union union;
	@ManyToOne
	@JoinColumn(name = "SAKHA_ID", nullable = false)
	private SakhaDetails sakhaDetails;
	@ManyToOne
	@JoinColumn(name = "STATE_ID", nullable = false)
	private State state;
	@ManyToOne
	@JoinColumn(name = "DISTRICT_ID", nullable = false)
	private District district;
	@ManyToOne
	@JoinColumn(name = "PANCHAYATH_ID", nullable = false)
	private PanchayathOffice panchayathOffice;
	@ManyToOne
	@JoinColumn(name = "POST_OFFICE_ID", nullable = false)
	private PostOffice postOffice;
	@ManyToOne
	@JoinColumn(name = "VILLAGE_ID", nullable = false)
	private VillageOffice villageOffice;
	@Column(name = "TOWN", nullable = false)
	private String town;
	@ManyToOne
	@JoinColumn(name = "WARD_ID", nullable = false)
	private Ward ward;
	@ManyToOne
	@JoinColumn(name = "GENDER_ID", nullable = false)
	private Gender gender;
	@Column(name = "DOB", nullable = false)
	private Date dob;
	@ManyToOne
	@JoinColumn(name = "BLOOD_GROUP_ID", nullable = false)
	private BloodGroup bloodGroup;
	@ManyToOne
	@JoinColumn(name = "QUALIFICATION_ID", nullable = false)
	private EducationQualification educationQualification;
	@ManyToOne
	@JoinColumn(name = "PHYSICAL_STATUS_ID", nullable = false)
	private PhysicalStatus physicalStatus;
	@ManyToOne
	@JoinColumn(name = "JOB_ID", nullable = false)
	private Job job;
	@ManyToOne
	@JoinColumn(name = "MARITAL_STATUS_ID", nullable = false)
	private MaritalStatus maritalStatus;
	@ManyToOne
	@JoinColumn(name = "FINANCIAL_STATUS_ID", nullable = false)
	private FinanceStatus financeStatus;
	@Column(name = "AADHAAR_NO")
	private String aadhaarNo;
	@Column(name = "ELECTION_ID_NO")
	private String electionIdNo;
	@Column(name = "PAN_NO")
	private String panNo;
	@Column(name = "DRIVING_LICENCE_NO")
	private String drivingLicenceNo;
	@Column(name = "PHOTO", nullable = false)
	private byte[] photo;
	@Column(name = "LAND_LINE")
	private String landLineNo;
	@Column(name = "MOBILE_1")
	private String mobile1;
	@Column(name = "MOBILE_2")
	private String mobile2;
	@Column(name = "EMAIL_ID", nullable = false)
	private String emailId;
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	@Column(name = "IS_DELETE", nullable = false)
	private boolean isDelete;

	public Member() {
		super();
	}

	public Member(long id, String memberName, String houseNo, String memeberCode, Union union,
			SakhaDetails sakhaDetails, State state, District district, PanchayathOffice panchayathOffice,
			PostOffice postOffice, VillageOffice villageOffice, String town, Ward ward, Gender gender, Date dob,
			BloodGroup bloodGroup, EducationQualification educationQualification, PhysicalStatus physicalStatus,
			Job job, MaritalStatus maritalStatus, FinanceStatus financeStatus, String aadhaarNo, String electionIdNo,
			String panNo, String drivingLicenceNo, byte[] photo, String landLineNo, String mobile1, String mobile2,
			String emailId, Date createdDate, boolean isDelete) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.houseNo = houseNo;
		this.memeberCode = memeberCode;
		this.union = union;
		this.sakhaDetails = sakhaDetails;
		this.state = state;
		this.district = district;
		this.panchayathOffice = panchayathOffice;
		this.postOffice = postOffice;
		this.villageOffice = villageOffice;
		this.town = town;
		this.ward = ward;
		this.gender = gender;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.educationQualification = educationQualification;
		this.physicalStatus = physicalStatus;
		this.job = job;
		this.maritalStatus = maritalStatus;
		this.financeStatus = financeStatus;
		this.aadhaarNo = aadhaarNo;
		this.electionIdNo = electionIdNo;
		this.panNo = panNo;
		this.drivingLicenceNo = drivingLicenceNo;
		this.photo = photo;
		this.landLineNo = landLineNo;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.emailId = emailId;
		this.createdDate = createdDate;
		this.isDelete = isDelete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getMemeberCode() {
		return memeberCode;
	}

	public void setMemeberCode(String memeberCode) {
		this.memeberCode = memeberCode;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public PanchayathOffice getPanchayathOffice() {
		return panchayathOffice;
	}

	public void setPanchayathOffice(PanchayathOffice panchayathOffice) {
		this.panchayathOffice = panchayathOffice;
	}

	public PostOffice getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(PostOffice postOffice) {
		this.postOffice = postOffice;
	}

	public VillageOffice getVillageOffice() {
		return villageOffice;
	}

	public void setVillageOffice(VillageOffice villageOffice) {
		this.villageOffice = villageOffice;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public FinanceStatus getFinanceStatus() {
		return financeStatus;
	}

	public void setFinanceStatus(FinanceStatus financeStatus) {
		this.financeStatus = financeStatus;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getLandLineNo() {
		return landLineNo;
	}

	public void setLandLineNo(String landLineNo) {
		this.landLineNo = landLineNo;
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
