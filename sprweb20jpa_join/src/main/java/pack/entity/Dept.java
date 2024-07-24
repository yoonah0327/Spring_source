package pack.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LazyInitializationException;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dept {
	@Id
	private int deptno; //요녀석이랑 
	private String dname;
	private String loc;
	
	
	//FetchType.LAZY: Dept 사용중 Emp는 필요할때 지연로딩.
	//세션이 열려있는동안 세션관리 필요하며, LazyInitializationException 조치 요.
	//FetchType.EAGER: Dept 사용중 Emp는 즉시로딩됨.(그래서 메모리낭비가있긴함) 참조 여부무관.
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
	@Builder.Default //Emp 엔티티가 생성될 때 list를 초기화함
	private List<Emp> list = new ArrayList<Emp>();
	
}
