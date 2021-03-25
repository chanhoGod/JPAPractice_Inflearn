package helloJpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity 
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq", initialValue = 1, allocationSize = 50)
public class Member4 {

	@Id @GeneratedValue	
	private Long id;

	@Column(name = "USERNAME") 
	private String userName;
	
//	@Column(name = "TEAM_ID")
//	private Long teamId;

	@ManyToOne						//멤버입장에서 N, 팀 입장에서 1
	@JoinColumn(name = "TEAM_ID")	//실제 이 컬럼을 무엇과 연관관계를 맺어야 하는가? --> 조인하는 컬럼이 어떤건지?
	private Team team;
	
	public Member4() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	

//	public Long getTeamId() {
//		return teamId;
//	}
//
//	public void setTeamId(Long teamId) {
//		this.teamId = teamId;
//	}



}
