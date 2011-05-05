package com.augmentum.training.model;


import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the role database table.
 * @author mason.xu
 * @version 1.0 2011/03/23
 */
@Entity
@Table(name="role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;

	@Column(name="role_type")
	private String roleType;

	//bi-directional many-to-many association to Groupinfo
    @ManyToMany
	@JoinTable(
		name="join_group_role"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="group_id")
			}
		)
	private Set<GroupInfo> groupinfos;

    public Role() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Role) {
        	Role d = (Role) obj;
            if (d.getRoleId() == null) {
                return false;
            } else {
                return d.getRoleId().equals(this.roleId) && 
                		d.getRoleType().equals(this.roleType);
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = roleId.hashCode();
        hashCode += roleType.hashCode();

        return hashCode;
    }
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Set<GroupInfo> getGroupinfos() {
		return this.groupinfos;
	}

	public void setGroupinfos(Set<GroupInfo> groupinfos) {
		this.groupinfos = groupinfos;
	}
	
}