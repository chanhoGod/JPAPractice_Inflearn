package helloJpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long Id;
	private String name;
	
	@OneToMany(mappedBy = "team")													//팀은 하나 멤버는 여러개 --> OneToMany 앞에 있는게 현재 클래스 기준
	private List<Member4> members = new ArrayList<Member4>();
	
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
	public List<Member4> getMembers() {
		return members;
	}
	public void setMembers(List<Member4> members) {
		this.members = members;
	}
	
	
}
