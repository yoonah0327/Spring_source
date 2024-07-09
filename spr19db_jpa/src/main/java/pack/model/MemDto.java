package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data //게터세터
@Builder//빌더패턴. 권장.
@NoArgsConstructor //기본생성자선언
@AllArgsConstructor//파라미터가있는 생성자선언
@Entity(name="mem") // db의 특정 테이블과 매핑
public class MemDto { //카멜케이스로 작성하면 자동으로 언더스코어네이밍컨벤션(_)을 따른다.
	
	@Id //pk칼럼에 요렇게 붙임
	//@Column(name="num") //만약 다를경우 요렇게 @column작업으로 이름 준다.
	private int num; 
	
	@Column(name="name", nullable=true) //null 허용여부. 우리는 db에서 null 허용하고있음. 
	private String name;
	
	private String addr;
}
