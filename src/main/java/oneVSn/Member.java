package oneVSn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

//@Entity 
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq", initialValue = 1, allocationSize = 50)
public class Member {

	@Id @GeneratedValue	
	private Long id;

	@Column(name = "USERNAME") 
	private String userName;	

	@ManyToOne											
	@JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)	//현재 일대다 관계 매핑중이며 주인이 아니기 때문에 쓰기, 업데이트를 불가하게 읽기전용으로 만듬
	private Team team;
	
	public Member() {
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
	


}
