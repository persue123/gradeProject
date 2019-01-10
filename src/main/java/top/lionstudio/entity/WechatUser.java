package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zw_wechat_user database table.
 * 
 */
@Entity
@Table(name="zw_wechat_user")
@NamedQuery(name="ZwWechatUser.findAll", query="SELECT z FROM WechatUser z")
public class WechatUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String openid;

	private String city;

	private String country;

	private String headimgurl;

	private String language;

	private String nickname;

	private String province;

	private Integer sex;

	private Integer userid;

	public WechatUser() {
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return this.headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}