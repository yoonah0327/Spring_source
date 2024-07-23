package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@SpringBootApplication
public class Sprweb20jpaJoinApplication {
	//1) 어플리케이션에서 SQL처리용 메소드연습
	//2) @MVC로 회원자료 처리 
	//3) @MVC로 회원자료 처리 (조인)
	//4) JPQL연습용 화면 작성 : AJAX
	
	@Autowired
	private EntityManagerFactory emf;
	
	//생성자 이후 자동 실행 
	@PostConstruct
	public void initMembers() {
		//hibernate 객체 사용: dept, emp 샘플 데이터를 JPQL을 이용해 저장하기
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			List<String> queries = new ArrayList<String>();
			
			queries.add("INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20, 'RESEARCH', 'DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30, 'SALES', 'CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');");
			
			queries.add("INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,TO_DATE('1981-11-17','YYYY-MM-DD'),5000,NULL,10);");
			queries.add("INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,TO_DATE('1981-05-01','YYYY-MM-DD'),2850,NULL,30);");
			queries.add("");
			queries.add("");
			queries.add("");
			queries.add("");
			queries.add("");
			queries.add("");
			
			
			tx.commit();
		} catch (Exception e) {
			System.out.println("err: "+e);
			tx.rollback();
		} finally {
			em.close();

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Sprweb20jpaJoinApplication.class, args);
	}

}
