package helloJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence의 unitName을 넘겨줘야함
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
//			Member member = new Member();											persist는 insert, find는 select
//			member.setId(2L);														remove는 delete
//			member.setName("helloB");
//			em.remove(findMember);													찾은애를 넣어주면 지워진다.
//			Member findMember = em.find(Member.class, 1L);
//			findMember.setName("HelloJPA");
			
			List<Member> result = em.createQuery("Select m from Member as m", Member.class).getResultList();
			for(Member member : result) {
				System.out.println(member.getName());
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
