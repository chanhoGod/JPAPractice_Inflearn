package proxy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			 
			
			Child child1 = new Child();
			Child child2 = new Child();
			
			Parent parent = new Parent();
			parent.addChild(child1);
			parent.addChild(child2);
			
			em.persist(parent);

			em.flush();
			em.clear();
			
			Parent findParent = em.find(Parent.class, parent.getId());
			findParent.getChildList().remove(0);
//			em.remove(findParent);
			
//			Team team = new Team();
//			team.setName("A");
//			em.persist(team);
//			
//			Member member1 = new Member();
//			member1.setUserName("HI");
//			em.persist(member1);
//			member1.setTeam(team);
//
//			em.flush();
//			em.clear();
//			
//			Member m = em.find(Member.class, member1.getId());
//			
//			List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();	//fetch Join전략 연관된것을 가져올 수 있음
			
//			Member member2 = new Member();
//			member2.setUserName("Hello");
//			em.persist(member2);
//			
//			
	
//			
//			Member m1 = em.find(Member.class, member1.getId());
//			System.out.println("m1 : " + m1.getClass());
//			Member m2 = em.getReference(Member.class, member2.getId());
//			System.out.println("멤버 클래스 비교 m1 == m2 : " + (m1.getClass() == m2.getClass())); 	//find는 서로 타입이 같음, 하지만 getReference에서는 프록시 객체를 받기 때문에
//																								//타입이 서로 안맞을 수 있다.
//			
//			Member reference = em.getReference(Member.class, member2.getId());
//			System.out.println("reference : " + reference.getClass());
//			
//		
//			Member findMember = em.getReference(Member.class, member.getId());					//가짜 프록시 객체
//			System.out.println("id : " + findMember.getId());
//			System.out.println("name : " + findMember.getUserName());
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		emf.close();
	
	}

}
