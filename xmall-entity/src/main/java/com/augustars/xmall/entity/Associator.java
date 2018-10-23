package com.augustars.xmall.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="sys_associator")
public class Associator implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long associatorId;		//	消费者主键
	private String associatorName;	//	消费者名称
	private String nickName;		//	昵称，登录名
	private String password;		//	登录密码
	private String gender;			//	性别：M-男，N-女
	private Rank rank;				//	会员等级
	private Long point;				//	会员积分
	private String idCard;			//	身份证号码
	private String cellphone;		//	联系电话
	private String email;			//	电子邮件
	private Status status;			//	状态
	private User createUser;		//	创建人
	private Date createTime;		//	创建时间
	private User updateUser;		//	修改人
	private Date updateTime;		//	修改时间
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="associator_id")
	public Long getAssociatorId() {
		return associatorId;
	}
	public void setAssociatorId(Long associatorId) {
		this.associatorId = associatorId;
	}
	@Column(name="associator_name")
	public String getAssociatorName() {
		return associatorName;
	}
	public void setAssociatorName(String associatorName) {
		this.associatorName = associatorName;
	}
	@Column(name="nickname")
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Column(name="passwrod")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@ManyToOne(targetEntity=Rank.class,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="rank_id")
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	@Column(name="point")
	public Long getPoint() {
		return point;
	}
	public void setPoint(Long point) {
		this.point = point;
	}
	@Column(name="id_card")
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	@Column(name="cellphone")
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@ManyToOne(targetEntity=Status.class,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="status_id")
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@ManyToOne(targetEntity=User.class,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="create_user")
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@ManyToOne(targetEntity=User.class,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="update_user")
	public User getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
