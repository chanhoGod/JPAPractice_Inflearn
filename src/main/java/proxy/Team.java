package proxy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Team {
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long Id;
	private String name;
	
	@OneToMany(mappedBy = "team")		//JoinColumn을 사용하지 않으면 중간 테이블이 생겨버린다.
	private List<Member> members = new ArrayList<Member>();
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	
	
}
