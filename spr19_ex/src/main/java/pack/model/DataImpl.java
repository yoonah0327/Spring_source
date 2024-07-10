package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	
	@Override
	public List<JikDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //<persistence-unit name="hello">
		EntityManager em = emf.createEntityManager(); //엔티티의 생명주기 관리. crud를 수행.
		EntityTransaction tx = em.getTransaction(); //transaction을 관리하는 인터페이스.
		
		List<JikDto> list = null;
		
		try {
			System.out.println("\n🎶🎶🎶직원 자료 전체출력(JPQL사용)🎶🎶🎶");
	
			list = em.createQuery("select e from JikDto as e", JikDto.class).getResultList();
			
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err : "+e);
		} finally {
			em.close();
			emf.close();
		}
		return list;
	}
	
	@Override
	public List<Object[]> selectcntBuser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //<persistence-unit name="hello">
		EntityManager em = emf.createEntityManager(); //엔티티의 생명주기 관리. crud를 수행.
		EntityTransaction tx = em.getTransaction(); //transaction을 관리하는 인터페이스.
		
		List<Object[]> result = null;
		
		try {
			System.out.println("\n🎶🎶🎶부서별 직원수(JPQL사용)🎶🎶🎶");
			//2개의 인덱스(부서번호, 직원수)를 갖는 배열을 담는 list
			result = em.createQuery("select j.buser_num, count(j.jikwon_no) from JikDto as j group by j.buser_num", Object[].class).getResultList();
		
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err : "+e);
		} finally {
			em.close();
			emf.close();
		}
		
		return result;
	}
	
	
	
	
}
