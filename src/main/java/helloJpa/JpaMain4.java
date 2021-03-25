package helloJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain4 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		try {//연관관계가 없기 때문에 계속 find로 찾아줘야 한다.
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);

			Member4 member = new Member4();
			member.setUserName("member1");
			member.setTeam(team);
			em.persist(member); 
			
			em.flush();
			em.clear();
			
			Member4 findMember = em.find(Member4.class, member.getId());
			
			List<Member4> members = findMember.getTeam().getMembers();
			for(Member4 member2 : members) {
				System.out.println("멤버 : " + member2.getId());
			}
			etx.commit();
		}catch(Exception e) {
			etx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
