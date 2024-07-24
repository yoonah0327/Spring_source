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
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;

@SpringBootApplication
public class Sprweb20jpaJoinApplication {
	//1) 어플리케이션에서 SQL처리용 JPA 메소드연습
	//2) @MVC로 회원자료 처리 
	//3) @MVC로 회원자료 처리 (조인)
	//4) JPQL연습용 화면 작성 : AJAX
	// H2 DB
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private DeptRepository deptRepository;
	
	@Autowired
	private EmpRepository empRepository;
	
	//생성자 이후 자동 실행. 
	@PostConstruct
	public void initMembers() {
		//hibernate 객체 사용: dept, emp 샘플 데이터를 JPQL을 이용해 저장하기
		EntityManager em = emf.createEntityManager(); //만든이유 : db저장용
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			List<String> queries = new ArrayList<String>();
			
			queries.add("INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');");

			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7369,'SMITH','CLERK',7902,parsedatetime('17-12-1980','dd-MM-yyyy'),800,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7499,'ALLEN','SALESMAN',7698,parsedatetime('20-02-1981','dd-MM-yyyy'),1600,300,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7521,'WARD','SALESMAN',7698,parsedatetime('22-02-1981','dd-MM-yyyy'),1250,500,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7566,'JONES','MANAGER',7839,parsedatetime('02-04-1981','dd-MM-yyyy'),2975,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7654,'MARTIN','SALESMAN',7698,parsedatetime('28-09-1981','dd-MM-yyyy'),1250,1400,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7698,'BLAKE','MANAGER',7839,parsedatetime('01-05-1981','dd-MM-yyyy'),2850,NULL,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7782,'CLARK','MANAGER',7839,parsedatetime('09-06-1981','dd-MM-yyyy'),2450,NULL,10);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7788,'SCOTT','ANALYST',7566,parsedatetime('13-07-1987','dd-MM-yyyy'),3000,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7839,'KING','PRESIDENT',NULL,parsedatetime('17-11-1981','dd-MM-yyyy'),5000,NULL,10);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7844,'TURNER','SALESMAN',7698,parsedatetime('08-09-1981','dd-MM-yyyy'),1500,0,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7876,'ADAMS','CLERK',7788,parsedatetime('13-07-1987','dd-MM-yyyy'),1100,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7900,'JAMES','CLERK',7698,parsedatetime('03-12-1981','dd-MM-yyyy'),950,NULL,30);");
			
			//반복처리로 쿼리 실행
			for(String que:queries) {
				em.createNativeQuery(que).executeUpdate();//위 queries.add들, jpql아니고 오리지날sql문들. 그래서 createNativeQuery.
				
			}
			
			
			
			tx.commit();
		} catch (Exception e) {
			System.out.println("err: "+e);
			tx.rollback();
		} finally {
			em.close();
		}
		// 사원번호 읽기
		Emp e1 = empRepository.findById(7369).get();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~"+e1.getEname()+"사원의 부서명은 "+e1.getDept().getDname());//SMITH사원의 부서명은 RESEARCH
	/*
		//직원추가 : 40번부서 Olivia 
		Dept dnum = deptRepository.findById(40).get();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~"+dnum.getDname()+" "+dnum.getDeptno());
		
		//40번부서의 다른 정보를 이용해 직원정보를 저장할 것이 아니면 find 없이 부서번호만 Dept 객체에 넣는다.
		//롬복의 builder()를 사용하여 Dept 객체를 빌더 패턴으로 생성.
		Dept d = Dept.builder().deptno(40).build();
		System.out.println(d.getDeptno());
		
		Emp my = Emp.builder()
				.empno(8000)
				.ename("Olivia")
				.dept(d)
				.build();
		empRepository.save(my);
	*/	
		//부서정보읽기: 10번
		Dept dept10 = deptRepository.findById(20).get();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~부서명: "+dept10.getDname());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~부서 위치: "+dept10.getLoc());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~근무인원수: "+dept10.getList().size());
		
		for(Emp imsi:dept10.getList()) {
			System.out.println("직원명: "+ imsi.getEname());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Sprweb20jpaJoinApplication.class, args);
	}

}
