package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	
	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //<persistence-unit name="hello">
		EntityManager em = emf.createEntityManager(); //엔티티의 생명주기 관리. crud를 수행.
		EntityTransaction tx = em.getTransaction(); //transaction을 관리하는 인터페이스.
		
		List<MemDto> list = null;
		
		try {
			// 레코드추가
			/*
			tx.begin();
			MemDto dto1 = new MemDto();
			dto1.setNum(4);
			dto1.setName("호빵맨");
			dto1.setAddr("서초구 방배동");
			em.persist(dto1);
			//insert는 오직1개만. 성공하면1 실패하면0
			//hibernate: insert pack.model.MemDto
			//실제 sql처리: insert into mem (addr, name, num) values (?, ?, ?)
			tx.commit();
			*/
			
			//레코드 수정
//			tx.begin();
//			MemDto dto2= em.find(MemDto.class, 4);
//			dto2.setName("세균맨");
//			tx.commit();
			//Hibernate: select memdto0_.num as num1_0_0_, memdto0_.addr as addr2_0_0_, memdto0_.name as name3_0_0_ from mem memdto0_ where memdto0_.num=?
			//Hibernate: update pack.model.MemDto
			//update mem set addr=?, name=? where num=?
			
			//레코드 삭제
//			tx.begin();
//			MemDto dto3= em.find(MemDto.class, 4);
//			em.remove(dto3);
//			tx.commit();
			
			System.out.println("\n💦부분 자료 읽기💦(단일엔티티) find()메소드사용-----");
			//public find(Class<T> entityClass, Object pk)
			MemDto mdto= em.find(MemDto.class, 2); //pk의 데이터만 출력가.
			System.out.println(mdto.getNum()+ "💦"+mdto.getName()+ "💦"+mdto.getAddr());
			
			System.out.println("\n💦💦부분 자료 읽기(복수엔티티)💦💦");
			List<MemDto> listPart = findByAddr(em, "강남");
			
			for(MemDto m: listPart) {
				System.out.println(m.getNum()+ "💦💦"+m.getName()+ "💦💦"+m.getAddr());
			}
			//hibernate: SELECT m FROM MemDto m WHERE m.addr LIKE :ss
			//select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_ where memdto0_.addr like ?
			
			
			System.out.println("\n🎶전체 자료 읽기🎶(JPQL사용)-----");
			
			/*
			list = findAll(em, MemDto.class);
			for(MemDto m: list) {
				System.out.println(m.getNum()+ "🎶"+m.getName()+ "🎶"+m.getAddr());
			}
			*/
			list = em.createQuery("select e from MemDto as e", MemDto.class).getResultList();
			//Hibernate ==> select e from MemDto as e : rdbms 종류에 관계없이 공통적으로 사용.
			//hibernate가 DBDialect로 보고 실제sql문으로 변환 ==>
			//select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_;	
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err : "+e);
		} finally {
			em.close();
			emf.close();
		}
		return list;
	}
	
	public List<MemDto> findByAddr(EntityManager em, String ss){
		// addr 필드가 특정 접두사ss로 시작하는 레코드읽기
		String jpql = "SELECT m FROM MemDto m WHERE m.addr LIKE :ss";
		
		TypedQuery<MemDto> query = em.createQuery(jpql, MemDto.class);
		//TypedQuery<entity> query = e.createQuery(jpql, emetity클래스)
		//JPQL을 작성하고 실행하는 역할
		query.setParameter("ss", ss+"%"); //sql의 like연산수행. 검색문자%
		return query.getResultList();
		
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla){
		return em.createQuery("select e from "+cla.getSimpleName()+" e", cla).getResultList();
		//sql문 아님. jpql.
		//cla.getName(): pack.model.DataDto
		//cla.getSimpleName(): DataDto
	}
	
}
