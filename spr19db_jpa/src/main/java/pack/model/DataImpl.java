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
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //<persistence-unit name="hello">
		EntityManager em = emf.createEntityManager(); //엔티티의 생명주기 관리. crud를 수행.
		EntityTransaction tx = em.getTransaction(); //transaction을 관리하는 인터페이스.
		
		List<MemDto> list = null;
		
		System.out.println("🎶전체 자료 읽기🎶-----");
		list = findAll(em, MemDto.class);
		for(MemDto m: list) {
			System.out.println(m.getNum()+ "🎶"+m.getName()+ "🎶"+m.getAddr());
		}
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla){
		return em.createQuery("select e from "+cla.getName()+" e", cla).getResultList();
		//sql문 아님. jpql.
		//cla.getName(): pack.model.DataDto
		//cla.getSimpleName(): DataDto
	}
	
}
