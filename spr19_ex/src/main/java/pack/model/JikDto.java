package pack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder//빌더패턴. 권장.
@NoArgsConstructor //기본생성자선언
@AllArgsConstructor//파라미터가있는 생성자선언
@Entity //?
@Table(name="jikwon") // db의 특정 테이블과 매핑. 

public class JikDto { //카멜케이스로 작성하면 자동으로 언더스코어네이밍컨벤션(_)을 따른다.
	
	@Id //pk칼럼에 요렇게 붙임
	private String jikwon_no; 
	
	private String jikwon_name, buser_num, jikwon_ibsail;
}
