package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data// 빌드없으면 데이타오케이. 빌드잇으면 게터세터. 
@Entity
@Table(name="sangdata")
public class Sangpum {
	@Id
	private int code;
	
	@Column(nullable = false)
	private String sang;
	
	private int su;
	private int dan;
	
	// 변수 ff
    //private int ff;  // 이 필드는 DB 테이블에는 존재하지 않음

}
