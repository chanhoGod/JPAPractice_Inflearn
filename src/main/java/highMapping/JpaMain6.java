package highMapping;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain6 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
//			Movie movie = new Movie();					//상속관계 매핑 -> DB는 상속관계를 수퍼클래스 서브클래스의 관계로 표ㅕㄴ할 수 있음
//			movie.setActor("bbbb");						//3가지 전략이 존재하며 JOIN, SINGLE_TABLE, PER_CLASS가 있는데 JOIN을 기본으로 깔고간다.
//			movie.setDirector("aaaa");					//테이블이 매우 단순할 경우나 확장 가능성이 없으면 SINGLE_TABLE을 사용
//			movie.setName("바람");
//			movie.setPrice(10000);
//			em.persist(movie);
//			
//
//			em.flush();
//			em.clear();
//			
//			Movie findMovie = em.find(Movie.class, movie.getId());
//			System.out.println("findMovie : " + findMovie.getName());
			
			Member member = new Member();
			member.setUserName("Jung");
			member.setCreatedBy("Kim");
			member.setCreateDate(LocalDateTime.now());
			
			em.persist(member);
			
			em.flush();
			em.clear();
			
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
		
	}
}
