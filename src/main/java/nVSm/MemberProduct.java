package nVSm;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
public class MemberProduct {
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@Column(name = "MEMBER_ID")
	private Member member;
	
	@ManyToOne
	@Column(name = "PRODUCT_ID")
	private Product product;
	
	@Column(name = "COUNT")
	private int count;
	@Column(name = "PRICE")
	private int price;
	
	@Column(name = "ORDERD_DATETIME")
	private LocalDateTime orderdDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getOrderdDateTime() {
		return orderdDateTime;
	}

	public void setOrderdDateTime(LocalDateTime orderdDateTime) {
		this.orderdDateTime = orderdDateTime;
	}
	
}
