package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain3 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		try {
			Member3 member1 = new Member3();
			member1.setUserName("A");
			
			Member3 member2 = new Member3();
			member2.setUserName("B");
			
			Member3 member3 = new Member3();
			member3.setUserName("C");
			
			em.persist(member1);
			em.persist(member2);
			em.persist(member3);
			
			System.out.println("1 : " + member1.getId());
			System.out.println("2 : " + member2.getId());
			System.out.println("3 : " + member3.getId());
			
			etx.commit();
		}catch(Exception e) {
			etx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
