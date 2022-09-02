package dev.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@Column(name = "USER_ID", length = 100)
	private String id;
		
	@Column(name = "USER_PASSWORD")
	private String Passwd;
	
	public User() {
		super();
	}

	public User(String id, String passWord) {
		super();
		this.id = id;
		this.Passwd = passWord;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getPasswd() {
		return Passwd;
	}

	public void setPassWord(String passWord) {
		this.Passwd = passWord;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", passWord=" + Passwd + "]";
	}
	
	
}
