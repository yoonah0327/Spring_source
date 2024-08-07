package pack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Jikwon {
	@Id
	private int jikwon_no;
	
	private String jikwon_name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="buser_num")
	private Buser buser;
	
	@Column(name="jikwon_jik")
	private String jik;
	private int jikwon_pay;
}
