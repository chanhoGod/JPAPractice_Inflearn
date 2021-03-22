package helloJpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity // jpa가 처음 로딩될때 사용되는 클래스라는 것을 인식한다.
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq", initialValue = 1, allocationSize = 50)
public class Member3 {

	@Id // primary key을 인식하는 어노테이션
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // ID 자동생성 각 DB의 방언에 따라 다르게 적용된다.
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")	//주로 오라클에서 많이 사용하는 전략으로 해당 시퀀스의 이름으로 매핑할 수 있다.
	private Long id;

	@Column(name = "name") // 마찬가지로 컬럼명과 변수명이 다를 경우에도 값을 지정해서 넣어줄 수 있다. nullable은 null관련설정 false는 notnull
	private String userName;
	private Integer age;

//	@Enumerated(EnumType.STRING)			//ENUM타입은 ORDINAL을 사용하면 안됨 그냥 STRING을 사용하는게 좋음
//	private RoleType roleType;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createDate;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastModifiedDate;
//	
//	@Lob
//	private String description;

	public Member3() {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
