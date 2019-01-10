package model;

import java.io.Serializable;
import javax.persistence.*;


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
	private String id;

	@Column(name="id_card")
	private String idCard;

	private String password;

	public SysUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}