package nVSm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id @GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy = "product")
	private List<MemberProduct> productMembers = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MemberProduct> getProductMembers() {
		return productMembers;
	}

	public void setProductMembers(List<MemberProduct> productMembers) {
		this.productMembers = productMembers;
	}
	
	
}
