package pack;

import java.awt.geom.CubicCurve2D;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;

import lombok.AllArgsConstructor;
import other.OtherClass;


@SpringBootApplication
@ComponentScan(basePackages= {"other"})
public class Sprweb13jpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb13jpaBasicApplication.class, args)
		.getBean(Sprweb13jpaBasicApplication.class).myExecute();
	}
	
	@Autowired
	ProductCrudRepository crudRepository;
	
	@Autowired
	OtherClass class1;
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
		
		insdata(); //추가 또는 수정
		delData(); //삭제
		selectData(); //목록보기
		
		class1.abc();
		
	}
	
	
	
	private void insdata() {
//		ProductVo productVo = new ProductVo();
//		productVo.setCode(4);
		
// productvo에서 @AllArgsConstructor ProductVo(Integer, String, Integer, Integer)
// 이 생성자를 사용하여 바로 값을 넣어줄수있다.
		
		//ProductVo productVo = new ProductVo(null, "볼펜", 2, 1500);
		ProductVo productVo = new ProductVo(4, "사랑비", 10, 20000);
//save가 하는일: 없는번호일경우 추가. 있는번호일경우 수정. 
		//System.out.println(productVo.toString());
		crudRepository.save(productVo);
	}
	
	public void delData() { //있으면 지우고, 없으면 통과. 
		crudRepository.deleteById(3);
	}
	
	
	//레코드 읽기
	private void selectData() {
		List<ProductVo> list = (List<ProductVo>)crudRepository.findAll();
		//System.out.println(list.get(0).getSang());
		System.out.println("전체 레코드 읽기-----------------");
		for(ProductVo p:list) {
			System.out.println(p.getCode()+" "+p.getSang()+" "+p.getSu()+" "+p.getDan());
		}
		
		System.out.println("1개 레코드 읽기--------------");
	//1개 레코드 읽기
		ProductVo vo = crudRepository.findById(2).get();
		System.out.println(vo.getCode()+" "+vo.getSang()+" "+vo.getSu()+" "+vo.getDan());
		
		
	}
	
}
