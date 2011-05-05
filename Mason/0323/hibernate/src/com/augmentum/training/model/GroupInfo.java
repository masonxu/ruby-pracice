package com.augmentum.training.model;


import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the groupinfo database table.
 * @author mason.xu
 */
@Entity
@Table(name="groupinfo")
public class GroupInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="group_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer groupId;

	@Column(name="group_type")
	private String groupType;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="groupinfos",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Role> roles;

	//bi-directional many-to-many association to Userinfo
    @ManyToMany
	@JoinTable(
		name="join_user_authority"
		, joinColumns={
			@JoinColumn(name="group_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="user_id")
			}
		)	
	private Set<UserInfo> userinfos;

    public GroupInfo() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GroupInfo) {
        	GroupInfo d = (GroupInfo) obj;
            if (d.getGroupId() == null) {
                return false;
            } else {
                return d.getGroupId().equals(this.groupId) && 
                		d.getGroupType().equals(this.groupType);
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = groupId.hashCode();
        hashCode += groupType.hashCode();

        return hashCode;
    }
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupType() {
		return this.groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Set<UserInfo> getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set<UserInfo> userinfos) {
		this.userinfos = userinfos;
	}
	
}
