package com.augmentum.training.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;
/**
 * The persistent class for the userinfo database table.
 * @author mason.xu
 */
@Entity
@Table(name="userinfo")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId; 

	private String username;

	//bi-directional many-to-many association to Groupinfo
	@ManyToMany(mappedBy="userinfos", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<GroupInfo> groupinfos;

    public UserInfo() {
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserInfo) {
        	UserInfo d = (UserInfo) obj;
            if (d.getUserId() == null) {
                return false;
            } else {
                return d.getUserId().equals(this.userId) && 
                		d.getUsername().equals(this.username);
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = userId.hashCode();
        hashCode += username.hashCode();

        return hashCode;
    }

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<GroupInfo> getGroupinfos() {
		return this.groupinfos;
	}

	public void setGroupinfos(Set<GroupInfo> groupinfos) {
		this.groupinfos = groupinfos;
	}
	
}