package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import pack.dto.DeptDto;
import pack.dto.EmpListDto;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;

@Controller
public class EmployController {
	@Autowired
	private EntityManagerFactory factory;

	@Autowired
	private EmpRepository empRepo;

	@Autowired
	private DeptRepository deptRepo;

	@GetMapping("/employ/list")
	public String emplist(Model model) { // 모든 직원 정보 출력
		// List<Emp> list = empRepo.findAll(); //기본메소드
		// List<Emp> list = empRepo.findAllByOrderByEmpnoAsc(); //메소드룰
		// List<Emp> list = empRepo.findAllByOrderByEmpnoDesc(); //메소드룰
		List<Emp> list = empRepo.getListAll();// JPQL
		// List<Emp> list = empRepo.getList(2000);

		model.addAttribute("list", list);
		return "employ/elist";
	}

	@GetMapping("/employ/dept") // 부서정보 출력
	public String emplist(@RequestParam("deptno") int deptno, Model model) {
		Dept d = deptRepo.findById(deptno).get();
		DeptDto dto = DeptDto.toDto(d);
		model.addAttribute("dto", dto);
		return "employ/dept"; //디티오가 넘어감
	}
	
	//JPQL 연습장 관련
	@GetMapping("/jpql")
	public String jpql() {
		return "jpql";
	}
	@ResponseBody //json으로 찍으려면, 넘어온내용으로 찍어주려면 responsebody요.
	@PostMapping("/jpql/test")//ajax가 요청한 값 들어옴
	public List<EmpListDto> test(@RequestParam("query")String query){
		//System.out.println(query); //select e from Emp as e
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<EmpListDto> list = null;
		try {
			// 전달받은 query(jpql)문을 실행
			TypedQuery<Emp> tQuery = em.createQuery(query, Emp.class);
			
			list = tQuery.getResultStream().map(EmpListDto::toDto).toList();//tQuery.getResultStream()로 여러값이 넘어옴. map은 메소드를 실행시켜주는 함수.
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
		return list; //최종적으로 dto로 리턴
	}
	
}
