package com.augustars.xmall.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="sys_role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long roleId;//	角色主键
	private String roleName;//	角色名称
	private List<Menu> menuList;//	菜单集合
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@ManyToMany(targetEntity=Menu.class, fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="sys_role_menu",
			joinColumns= {@JoinColumn(name="role_id")},
			inverseJoinColumns= {@JoinColumn(name="menu_id")})
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}
