package com.jo.sndp.dao.modal;

import com.jo.sndp.entity.BloodGroup;
import com.jo.sndp.entity.Designation;
import com.jo.sndp.entity.EducationQualification;
import com.jo.sndp.entity.Gender;
import com.jo.sndp.entity.Job;
import com.jo.sndp.entity.MaritalStatus;
import com.jo.sndp.entity.PhysicalStatus;
import com.jo.sndp.entity.RelationShip;

public class FamilyMember {
	private String name;
	private String code;
	private RelationShip relation;
	private BloodGroup blood;
	private String dob;
	private int age;
	private EducationQualification qualification;
	private PhysicalStatus physicalStatus;
	private Job job;
	private MaritalStatus maritalStatus;
	private Gender gender;
	private String pic;
	private byte[] picSource;
	private String adhaar;
	private String election;
	private String pan;
	private String drivingLicence;
	private String mobile1;
	private String mobile2;
	private String email;
	private Designation designation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public RelationShip getRelation() {
		return relation;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setRelation(RelationShip relation) {
		this.relation = relation;
	}

	public BloodGroup getBlood() {
		return blood;
	}

	public void setBlood(BloodGroup blood) {
		this.blood = blood;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public EducationQualification getQualification() {
		return qualification;
	}

	public void setQualification(EducationQualification qualification) {
		this.qualification = qualification;
	}

	public PhysicalStatus getPhysicalStatus() {
		return physicalStatus;
	}

	public void setPhysicalStatus(PhysicalStatus physicalStatus) {
		this.physicalStatus = physicalStatus;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public byte[] getPicSource() {
		return picSource;
	}

	public void setPicSource(byte[] picSource) {
		this.picSource = picSource;
	}

	public String getAdhaar() {
		return adhaar;
	}

	public void setAdhaar(String adhaar) {
		this.adhaar = adhaar;
	}

	public String getElection() {
		return election;
	}

	public void setElection(String election) {
		this.election = election;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
