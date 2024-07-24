package pack.entity;



import java.util.Date;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class Emp {
	
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr; //관리자 직원번호
	
	@Temporal(TemporalType.DATE) //날짜타입 매핑시 사용
	private Date hiredate; //입사일
	private Double sal;
	private Double comm;
	//private Integer deptno; //공통칼럼
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "deptno", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))//비활성화
	private Dept dept;
	
}
