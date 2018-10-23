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
@Table(name="sys_product_sku")
public class Sku implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long skuId;				//	sku主键
	private Product product;		//	商品主键
	private String skuCode;			//	sku编码
	private Double price;			//	价格
	private Double preferential;	//	优惠金额
	private Long proint;			//	积分
	private Long stock;				//	库存
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_sku_id")
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	@ManyToOne(targetEntity=Product.class,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPreferential() {
		return preferential;
	}
	public void setPreferential(Double preferential) {
		this.preferential = preferential;
	}
	public Long getProint() {
		return proint;
	}
	public void setProint(Long proint) {
		this.proint = proint;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	
}
