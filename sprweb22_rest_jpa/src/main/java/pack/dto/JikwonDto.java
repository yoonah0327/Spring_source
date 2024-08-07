package pack.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Jikwon;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JikwonDto {
	
	private int jikwon_no;
	private String jikwon_name;
	private String buser_name;
	
	@Column(name="jikwon_jik")
	private String jik;
	private int jikwon_pay;
	
	public static JikwonDto toDto(Jikwon jikwon) { //entity to dto
		return JikwonDto.builder()
				.jikwon_no(jikwon.getJikwon_no())
				.jikwon_name(jikwon.getJikwon_name())
				.buser_name(jikwon.getBuser().getBuser_name())
				.jik(jikwon.getJik())
				.jikwon_pay(jikwon.getJikwon_pay())
				.build();
	}
}
