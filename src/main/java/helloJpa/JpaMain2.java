package helloJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence의 unitName을 넘겨줘야함
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
//			//비영속
//			Member member = new Member();
//			member.setId(101L);
//			member.setName("helloJPA");
			
			//영속
//			System.out.println("=== before ===");
//			em.persist(member);											//persist를 하는순간 DB에 저장되는 것이 아니다. DB에 저장되는 순간은 commit을 했을 때 저장된다.
//			System.out.println("=== after ===");		
//			Member findMember1 = em.find(Member.class, 101L);			//같은 식별자로 처음 조회할때는 쿼리로 DB에서 가져와야 함
//			Member findMember2 = em.find(Member.class, 101L);			//이때는 DB로 쿼리를 날려서 가져오는 것이 아니라 1차캐시에서 가져오는 것
//			
//			System.out.println("result : "+ (findMember1 == findMember2)); //동일성을 보장한다.

//			em.flush() 													//바로 쿼리에 커밋이 되버림 
//			em.detach(member);											//영속 -> 준영속 커밋을 했을 때에도 결과가 반영되지 않는다. 
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
