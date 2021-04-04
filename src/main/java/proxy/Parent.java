package proxy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent {

	@Id
	@GeneratedValue
	@Column(name = "parent_id")
	private Long id;
	
	private String name;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)	//parent를 중심으로 사용하고 싶을 때 parent만 persist하면 연관된 엔티티도 persist됨
	private List<Child> childList = new ArrayList<>();									//orphanRemoval은 고아객체를 자동으로 제거시켜준다.
	
	public void addChild(Child child) {
		childList.add(child);
		child.setParent(this);
	}
	
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

	public List<Child> getChildList() {
		return childList;
	}

	public void setChildList(List<Child> childList) {
		this.childList = childList;
	}
	
	
	
}
