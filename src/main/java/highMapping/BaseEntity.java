package highMapping;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass						//매핑 정보만 받는 수퍼클래스
public abstract class BaseEntity {
	
	private String createdBy;
	private LocalDateTime createDate;
	private String modifiedBy;
	private LocalDateTime lastModifiedDate;		//다음과 같은 내용이 모든 테이블에 들어가야 한다면 전부다 고쳐야 함 이것을 수퍼클래스로 만들어서 상속받을 수 있게 한게 MappedSuperclass
	public String getCreatedBy() {				//상속관계 매핑 이런게 아니라 수퍼클래스에 있는 컬럼들을 하위 서브클래스들이 사용할 수 있도록 해주는 것 
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	
	
}
