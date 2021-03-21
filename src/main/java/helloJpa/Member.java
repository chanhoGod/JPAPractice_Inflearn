package helloJpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity									//jpa가 처음 로딩될때 사용되는 클래스라는 것을 인식한다.
//@Table(name = "USER")					//만약 테이블이름과 객체명이 다를때 이런식으로 테이블을 지정해서 값을 넣어줄 수 있다.
public class Member {
	
	@Id									//primary key을 인식하는 어노테이션
	private long id;
	
	//@Column(name = "username")		//마찬가지로 컬럼명과 변수명이 다를 경우에도 값을 지정해서 넣어줄 수 있다.
	private String name;
	
	public Member() {
		
	}
	
	public Member(long id, String name) {
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
