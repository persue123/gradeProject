package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the info_person_info database table.
 * 
 */
@Entity
@Table(name="info_person_info")
@NamedQuery(name="InfoPersonInfo.findAll", query="SELECT i FROM InfoPersonInfo i")
public class InfoPersonInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer personId;
	private String addedAttribute1;
	private String addedAttribute2;
	private String addedAttribute3;
	private String addedAttribute4;
	private String addedAttribute5;
	private Integer baseProTownByResidencePlaceId;
	private String campusCardNum;
	private String campusNum;
	private String cardTypeCode;
	private Date censusRegisterDate;
	private String className;
	private Integer collegeId;
	private Integer collegeId1;
	private Integer collegeId2;
	private String collegeName;
	private String collegeNum;
	private Date createTime;
	private String dutyCode;
	private String email;
	private Date entrYearMon;
	private String famillyAddress;
	private String familyCity;
	private String familyProvince;
	private String familyRoadCode;
	private String familyRoadName;
	private String familyRoadNum;
	private String familyTown;
	private String familyType;
	private String famPostcalCode;
	private String famTelephone;
	private String genderCode;
	private String grade;
	private String headimgurl;
	private String healthCode;
	private String hujiAddress;
	private String hujiCity;
	private String hujiProvince;
	private String hujiTown;
	private Integer infoTypeCode;
	private Integer isChangePwd;
	private Integer isMarried;
	private String lastDegree;
	private String lastDegreeSchool;
	private Date lastDegreeTime;
	private String lastStudyLevel;
	private String lastStudyLevelSchool;
	private Date lastStudyLevelTime;
	private String majorName;
	private String majorNum;
	private String mobilePhone;
	private Integer modifierId;
	private String modifyBusiness;
	private Integer modifyerId;
	private Date modifyTime;
	private String msn;
	private Integer nationId;
	private String nativeCity;
	private String nativeProvince;
	private String nativeRoadCode;
	private String nativeRoadName;
	private String nativeRoadNum;
	private String nativeTown;
	private String odlPerNum;
	private String oldPerNum;
	private Integer peopleId;
	private String perAddress;
	private Date perBirthday;
	private String perEnglishFamilyName;
	private String perEnglishGivenName;
	private String perEnglishName;
	private String perIdCard;
	private String perName;
	private String perNativePlace;
	private String perNum;
	private String perPostalCode;
	private String perPwd;
	private String personInfoCode;
	private String personIntroduction;
	private String personStatus;
	private String personUnit;
	private String perTelephone;
	private String perTypeCode;
	private String politicsCode;
	private Date proStartTime;
	private String proTechPositionCode;
	private String qq;
	private String relation;
	private String religion;
	private String remark;
	private String researchDirection;
	private String sduEmail;
	private String secondPerType;
	private Date spouseBirthday;
	private String spouseName;
	private String spousePhone;
	private String spousePoliceCode;
	private String spouseStudyLevelCode;
	private String spouseUnitDuty;
	private String teaDuty;
	private String unitCity;
	private String unitProvince;
	private String unitTown;
	private String website;
	private String websiteEng;
	private String wechat;
	private String xmpy;

	public InfoPersonInfo() {
	}


	@Id
	@SequenceGenerator(name="INFO_PERSON_INFO_PERSONID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INFO_PERSON_INFO_PERSONID_GENERATOR")
	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId( Integer personId) {
		this.personId = personId;
	}


	public String getAddedAttribute1() {
		return this.addedAttribute1;
	}

	public void setAddedAttribute1(String addedAttribute1) {
		this.addedAttribute1 = addedAttribute1;
	}


	public String getAddedAttribute2() {
		return this.addedAttribute2;
	}

	public void setAddedAttribute2(String addedAttribute2) {
		this.addedAttribute2 = addedAttribute2;
	}


	public String getAddedAttribute3() {
		return this.addedAttribute3;
	}

	public void setAddedAttribute3(String addedAttribute3) {
		this.addedAttribute3 = addedAttribute3;
	}


	public String getAddedAttribute4() {
		return this.addedAttribute4;
	}

	public void setAddedAttribute4(String addedAttribute4) {
		this.addedAttribute4 = addedAttribute4;
	}


	public String getAddedAttribute5() {
		return this.addedAttribute5;
	}

	public void setAddedAttribute5(String addedAttribute5) {
		this.addedAttribute5 = addedAttribute5;
	}


	public Integer getBaseProTownByResidencePlaceId() {
		return this.baseProTownByResidencePlaceId;
	}

	public void setBaseProTownByResidencePlaceId( Integer baseProTownByResidencePlaceId) {
		this.baseProTownByResidencePlaceId = baseProTownByResidencePlaceId;
	}


	public String getCampusCardNum() {
		return this.campusCardNum;
	}

	public void setCampusCardNum(String campusCardNum) {
		this.campusCardNum = campusCardNum;
	}


	public String getCampusNum() {
		return this.campusNum;
	}

	public void setCampusNum(String campusNum) {
		this.campusNum = campusNum;
	}


	public String getCardTypeCode() {
		return this.cardTypeCode;
	}

	public void setCardTypeCode(String cardTypeCode) {
		this.cardTypeCode = cardTypeCode;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCensusRegisterDate() {
		return this.censusRegisterDate;
	}

	public void setCensusRegisterDate(Date censusRegisterDate) {
		this.censusRegisterDate = censusRegisterDate;
	}


	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}


	public Integer getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId( Integer collegeId) {
		this.collegeId = collegeId;
	}


	public Integer getCollegeId1() {
		return this.collegeId1;
	}

	public void setCollegeId1( Integer collegeId1) {
		this.collegeId1 = collegeId1;
	}


	public Integer getCollegeId2() {
		return this.collegeId2;
	}

	public void setCollegeId2( Integer collegeId2) {
		this.collegeId2 = collegeId2;
	}


	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getCollegeNum() {
		return this.collegeNum;
	}

	public void setCollegeNum(String collegeNum) {
		this.collegeNum = collegeNum;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getDutyCode() {
		return this.dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getEntrYearMon() {
		return this.entrYearMon;
	}

	public void setEntrYearMon(Date entrYearMon) {
		this.entrYearMon = entrYearMon;
	}


	public String getFamillyAddress() {
		return this.famillyAddress;
	}

	public void setFamillyAddress(String famillyAddress) {
		this.famillyAddress = famillyAddress;
	}


	public String getFamilyCity() {
		return this.familyCity;
	}

	public void setFamilyCity(String familyCity) {
		this.familyCity = familyCity;
	}


	public String getFamilyProvince() {
		return this.familyProvince;
	}

	public void setFamilyProvince(String familyProvince) {
		this.familyProvince = familyProvince;
	}


	public String getFamilyRoadCode() {
		return this.familyRoadCode;
	}

	public void setFamilyRoadCode(String familyRoadCode) {
		this.familyRoadCode = familyRoadCode;
	}


	public String getFamilyRoadName() {
		return this.familyRoadName;
	}

	public void setFamilyRoadName(String familyRoadName) {
		this.familyRoadName = familyRoadName;
	}


	public String getFamilyRoadNum() {
		return this.familyRoadNum;
	}

	public void setFamilyRoadNum(String familyRoadNum) {
		this.familyRoadNum = familyRoadNum;
	}


	public String getFamilyTown() {
		return this.familyTown;
	}

	public void setFamilyTown(String familyTown) {
		this.familyTown = familyTown;
	}


	public String getFamilyType() {
		return this.familyType;
	}

	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}


	public String getFamPostcalCode() {
		return this.famPostcalCode;
	}

	public void setFamPostcalCode(String famPostcalCode) {
		this.famPostcalCode = famPostcalCode;
	}


	public String getFamTelephone() {
		return this.famTelephone;
	}

	public void setFamTelephone(String famTelephone) {
		this.famTelephone = famTelephone;
	}


	public String getGenderCode() {
		return this.genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}


	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getHeadimgurl() {
		return this.headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}


	public String getHealthCode() {
		return this.healthCode;
	}

	public void setHealthCode(String healthCode) {
		this.healthCode = healthCode;
	}


	public String getHujiAddress() {
		return this.hujiAddress;
	}

	public void setHujiAddress(String hujiAddress) {
		this.hujiAddress = hujiAddress;
	}


	public String getHujiCity() {
		return this.hujiCity;
	}

	public void setHujiCity(String hujiCity) {
		this.hujiCity = hujiCity;
	}


	public String getHujiProvince() {
		return this.hujiProvince;
	}

	public void setHujiProvince(String hujiProvince) {
		this.hujiProvince = hujiProvince;
	}


	public String getHujiTown() {
		return this.hujiTown;
	}

	public void setHujiTown(String hujiTown) {
		this.hujiTown = hujiTown;
	}


	public Integer getInfoTypeCode() {
		return this.infoTypeCode;
	}

	public void setInfoTypeCode( Integer infoTypeCode) {
		this.infoTypeCode = infoTypeCode;
	}


	public Integer getIsChangePwd() {
		return this.isChangePwd;
	}

	public void setIsChangePwd( Integer isChangePwd) {
		this.isChangePwd = isChangePwd;
	}


	public Integer getIsMarried() {
		return this.isMarried;
	}

	public void setIsMarried( Integer isMarried) {
		this.isMarried = isMarried;
	}


	public String getLastDegree() {
		return this.lastDegree;
	}

	public void setLastDegree(String lastDegree) {
		this.lastDegree = lastDegree;
	}


	public String getLastDegreeSchool() {
		return this.lastDegreeSchool;
	}

	public void setLastDegreeSchool(String lastDegreeSchool) {
		this.lastDegreeSchool = lastDegreeSchool;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastDegreeTime() {
		return this.lastDegreeTime;
	}

	public void setLastDegreeTime(Date lastDegreeTime) {
		this.lastDegreeTime = lastDegreeTime;
	}


	public String getLastStudyLevel() {
		return this.lastStudyLevel;
	}

	public void setLastStudyLevel(String lastStudyLevel) {
		this.lastStudyLevel = lastStudyLevel;
	}


	public String getLastStudyLevelSchool() {
		return this.lastStudyLevelSchool;
	}

	public void setLastStudyLevelSchool(String lastStudyLevelSchool) {
		this.lastStudyLevelSchool = lastStudyLevelSchool;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastStudyLevelTime() {
		return this.lastStudyLevelTime;
	}

	public void setLastStudyLevelTime(Date lastStudyLevelTime) {
		this.lastStudyLevelTime = lastStudyLevelTime;
	}


	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}


	public String getMajorNum() {
		return this.majorNum;
	}

	public void setMajorNum(String majorNum) {
		this.majorNum = majorNum;
	}


	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public Integer getModifierId() {
		return this.modifierId;
	}

	public void setModifierId( Integer modifierId) {
		this.modifierId = modifierId;
	}


	public String getModifyBusiness() {
		return this.modifyBusiness;
	}

	public void setModifyBusiness(String modifyBusiness) {
		this.modifyBusiness = modifyBusiness;
	}


	public Integer getModifyerId() {
		return this.modifyerId;
	}

	public void setModifyerId( Integer modifyerId) {
		this.modifyerId = modifyerId;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}


	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}


	public Integer getNationId() {
		return this.nationId;
	}

	public void setNationId( Integer nationId) {
		this.nationId = nationId;
	}


	public String getNativeCity() {
		return this.nativeCity;
	}

	public void setNativeCity(String nativeCity) {
		this.nativeCity = nativeCity;
	}


	public String getNativeProvince() {
		return this.nativeProvince;
	}

	public void setNativeProvince(String nativeProvince) {
		this.nativeProvince = nativeProvince;
	}


	public String getNativeRoadCode() {
		return this.nativeRoadCode;
	}

	public void setNativeRoadCode(String nativeRoadCode) {
		this.nativeRoadCode = nativeRoadCode;
	}


	public String getNativeRoadName() {
		return this.nativeRoadName;
	}

	public void setNativeRoadName(String nativeRoadName) {
		this.nativeRoadName = nativeRoadName;
	}


	public String getNativeRoadNum() {
		return this.nativeRoadNum;
	}

	public void setNativeRoadNum(String nativeRoadNum) {
		this.nativeRoadNum = nativeRoadNum;
	}


	public String getNativeTown() {
		return this.nativeTown;
	}

	public void setNativeTown(String nativeTown) {
		this.nativeTown = nativeTown;
	}


	public String getOdlPerNum() {
		return this.odlPerNum;
	}

	public void setOdlPerNum(String odlPerNum) {
		this.odlPerNum = odlPerNum;
	}


	public String getOldPerNum() {
		return this.oldPerNum;
	}

	public void setOldPerNum(String oldPerNum) {
		this.oldPerNum = oldPerNum;
	}


	public Integer getPeopleId() {
		return this.peopleId;
	}

	public void setPeopleId( Integer peopleId) {
		this.peopleId = peopleId;
	}


	public String getPerAddress() {
		return this.perAddress;
	}

	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}


	@Temporal(TemporalType.DATE)
	public Date getPerBirthday() {
		return this.perBirthday;
	}

	public void setPerBirthday(Date perBirthday) {
		this.perBirthday = perBirthday;
	}


	public String getPerEnglishFamilyName() {
		return this.perEnglishFamilyName;
	}

	public void setPerEnglishFamilyName(String perEnglishFamilyName) {
		this.perEnglishFamilyName = perEnglishFamilyName;
	}


	public String getPerEnglishGivenName() {
		return this.perEnglishGivenName;
	}

	public void setPerEnglishGivenName(String perEnglishGivenName) {
		this.perEnglishGivenName = perEnglishGivenName;
	}


	public String getPerEnglishName() {
		return this.perEnglishName;
	}

	public void setPerEnglishName(String perEnglishName) {
		this.perEnglishName = perEnglishName;
	}


	public String getPerIdCard() {
		return this.perIdCard;
	}

	public void setPerIdCard(String perIdCard) {
		this.perIdCard = perIdCard;
	}


	public String getPerName() {
		return this.perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}


	public String getPerNativePlace() {
		return this.perNativePlace;
	}

	public void setPerNativePlace(String perNativePlace) {
		this.perNativePlace = perNativePlace;
	}


	public String getPerNum() {
		return this.perNum;
	}

	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}


	public String getPerPostalCode() {
		return this.perPostalCode;
	}

	public void setPerPostalCode(String perPostalCode) {
		this.perPostalCode = perPostalCode;
	}


	public String getPerPwd() {
		return this.perPwd;
	}

	public void setPerPwd(String perPwd) {
		this.perPwd = perPwd;
	}


	public String getPersonInfoCode() {
		return this.personInfoCode;
	}

	public void setPersonInfoCode(String personInfoCode) {
		this.personInfoCode = personInfoCode;
	}


	@Lob
	public String getPersonIntroduction() {
		return this.personIntroduction;
	}

	public void setPersonIntroduction(String personIntroduction) {
		this.personIntroduction = personIntroduction;
	}


	public String getPersonStatus() {
		return this.personStatus;
	}

	public void setPersonStatus(String personStatus) {
		this.personStatus = personStatus;
	}


	public String getPersonUnit() {
		return this.personUnit;
	}

	public void setPersonUnit(String personUnit) {
		this.personUnit = personUnit;
	}


	public String getPerTelephone() {
		return this.perTelephone;
	}

	public void setPerTelephone(String perTelephone) {
		this.perTelephone = perTelephone;
	}


	public String getPerTypeCode() {
		return this.perTypeCode;
	}

	public void setPerTypeCode(String perTypeCode) {
		this.perTypeCode = perTypeCode;
	}


	public String getPoliticsCode() {
		return this.politicsCode;
	}

	public void setPoliticsCode(String politicsCode) {
		this.politicsCode = politicsCode;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getProStartTime() {
		return this.proStartTime;
	}

	public void setProStartTime(Date proStartTime) {
		this.proStartTime = proStartTime;
	}


	public String getProTechPositionCode() {
		return this.proTechPositionCode;
	}

	public void setProTechPositionCode(String proTechPositionCode) {
		this.proTechPositionCode = proTechPositionCode;
	}


	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}


	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}


	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getResearchDirection() {
		return this.researchDirection;
	}

	public void setResearchDirection(String researchDirection) {
		this.researchDirection = researchDirection;
	}


	public String getSduEmail() {
		return this.sduEmail;
	}

	public void setSduEmail(String sduEmail) {
		this.sduEmail = sduEmail;
	}


	public String getSecondPerType() {
		return this.secondPerType;
	}

	public void setSecondPerType(String secondPerType) {
		this.secondPerType = secondPerType;
	}


	@Temporal(TemporalType.DATE)
	public Date getSpouseBirthday() {
		return this.spouseBirthday;
	}

	public void setSpouseBirthday(Date spouseBirthday) {
		this.spouseBirthday = spouseBirthday;
	}


	public String getSpouseName() {
		return this.spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}


	public String getSpousePhone() {
		return this.spousePhone;
	}

	public void setSpousePhone(String spousePhone) {
		this.spousePhone = spousePhone;
	}


	public String getSpousePoliceCode() {
		return this.spousePoliceCode;
	}

	public void setSpousePoliceCode(String spousePoliceCode) {
		this.spousePoliceCode = spousePoliceCode;
	}


	public String getSpouseStudyLevelCode() {
		return this.spouseStudyLevelCode;
	}

	public void setSpouseStudyLevelCode(String spouseStudyLevelCode) {
		this.spouseStudyLevelCode = spouseStudyLevelCode;
	}


	public String getSpouseUnitDuty() {
		return this.spouseUnitDuty;
	}

	public void setSpouseUnitDuty(String spouseUnitDuty) {
		this.spouseUnitDuty = spouseUnitDuty;
	}


	public String getTeaDuty() {
		return this.teaDuty;
	}

	public void setTeaDuty(String teaDuty) {
		this.teaDuty = teaDuty;
	}


	public String getUnitCity() {
		return this.unitCity;
	}

	public void setUnitCity(String unitCity) {
		this.unitCity = unitCity;
	}


	public String getUnitProvince() {
		return this.unitProvince;
	}

	public void setUnitProvince(String unitProvince) {
		this.unitProvince = unitProvince;
	}


	public String getUnitTown() {
		return this.unitTown;
	}

	public void setUnitTown(String unitTown) {
		this.unitTown = unitTown;
	}


	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}


	public String getWebsiteEng() {
		return this.websiteEng;
	}

	public void setWebsiteEng(String websiteEng) {
		this.websiteEng = websiteEng;
	}


	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}


	public String getXmpy() {
		return this.xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}

}