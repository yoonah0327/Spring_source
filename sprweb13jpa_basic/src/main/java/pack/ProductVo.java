package pack;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product") //name없으면 PRODUCT_VO가 기본이름.
public class ProductVo {
	@Id
	private Integer code;
	private String sang;
	private Integer su;
	private Integer dan;
}
