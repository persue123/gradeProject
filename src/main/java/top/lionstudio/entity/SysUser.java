package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_user database table.
 * 
 */
@Entity
@Table(name="sys_user")
@NamedQuery(name="SysUser.findAll", query="SELECT s FROM SysUser s")
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer sysusrid;

	private String authority;

	private Integer createrId;



	@Temporal(TemporalType.TIMESTAMP)
	private Date lastBsloginTime;



	private String loginName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date loginTime;

	private String matchedPerCode;

	private String nickName;

	private String password;

	private String passwordStatus;



	private String pwd;

	private String unionid;

	private Integer userid;

	private String usertype;

	private String wechat;



	public SysUser() {
	}

	public Integer getSysusrid() {
		return this.sysusrid;
	}

	public void setSysusrid(int sysusrid) {
		this.sysusrid = sysusrid;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	


	public Date getLastBsloginTime() {
		return this.lastBsloginTime;
	}

	public void setLastBsloginTime(Date lastBsloginTime) {
		this.lastBsloginTime = lastBsloginTime;
	}


	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getMatchedPerCode() {
		return this.matchedPerCode;
	}

	public void setMatchedPerCode(String matchedPerCode) {
		this.matchedPerCode = matchedPerCode;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordStatus() {
		return this.passwordStatus;
	}

	public void setPasswordStatus(String passwordStatus) {
		this.passwordStatus = passwordStatus;
	}


	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUnionid() {
		return this.unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}

}