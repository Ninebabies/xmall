package com.augustars.xmall.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="sys_county")
public class County implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long countyId;		//	区县主键
	private Province province;	//	所在省份
	private City city;			//	所在城市
	private String countyName;	//	区县名称
	private String countyCode;	//	区县编码
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="county_id")
	public Long getCountyId() {
		return countyId;
	}
	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}
	@ManyToOne(targetEntity=Province.class,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="province_Id")
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	@ManyToOne(targetEntity=City.class,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="city_id")
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	
}
