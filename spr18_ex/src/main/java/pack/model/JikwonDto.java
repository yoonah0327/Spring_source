package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JikwonDto {
	private String jikwon_no, jikwon_name, buser_name, jikwon_ibsail, jikwon_pay, cc;
}
