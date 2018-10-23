package com.augustars.xmall.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="sys_province")
public class Province implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long provinceId;		//	省份主键
	private String provinceName;	//	省份名称
	private String provinceCode;	//	省份编码
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="province_id")
	public Long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	@Column(name="province_name")
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	@Column(name="province_code")
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
}
