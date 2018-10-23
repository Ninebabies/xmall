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
@Table(name="sys_rank")
public class Rank implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long rankId;			//	会员等级主键
	private String rankName;		//	等级名称
	private Integer lowestPoint;	//	最低积分
	private Integer highestPoint;	//	最高积分
	private Long sortOrder;			//	排序
	private User createUser;		//	创建人
	private Date createTime;		//	创建时间
	private User updateUser;		//	修改人
	private Date updateTime;		//	修改时间
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rank_id")
	public Long getRankId() {
		return rankId;
	}
	public void setRankId(Long rankId) {
		this.rankId = rankId;
	}
	@Column(name="rank_name")
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	@Column(name="lowest_point")
	public Integer getLowestPoint() {
		return lowestPoint;
	}
	public void setLowestPoint(Integer lowestPoint) {
		this.lowestPoint = lowestPoint;
	}
	@Column(name="highest_point")
	public Integer getHighestPoint() {
		return highestPoint;
	}
	public void setHighestPoint(Integer highestPoint) {
		this.highestPoint = highestPoint;
	}
	@Column(name="sort_order")
	public Long getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
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
